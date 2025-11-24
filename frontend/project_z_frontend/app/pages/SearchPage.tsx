import { QueryClient } from "@tanstack/react-query";
import { useEffect, useState } from "react";
import { useLoaderData ,useNavigate,useSearchParams, type LoaderFunctionArgs } from "react-router";
import { searchOptions } from "~/helpers/SearchOptions";
import { queryClient } from "~/lib/queryClient";
import { useQuery } from '@tanstack/react-query';
import type { Route } from "../+types/root";
import AnimeCard from "~/components/Card/AnimeCard";
import SearchBar from "~/components/SearchBar";
import SkeletonCard from "~/components/Card/SceletonCard";

export async function clientLoader({ request }: Route.ClientLoaderArgs){
    const url = new URL(request.url);
    const query = url.searchParams.get('query') || '';

    if (!query) return null;

    return await queryClient.prefetchQuery(searchOptions(query));
};


const Search : React.FC = ()=> {
    const [searchParams] = useSearchParams();
    const queryStr = searchParams.get('query') || '';
    const navigate = useNavigate();

    const handleMainSearch = (query: string) => {
        navigate(`/search?query=${encodeURIComponent(query)}`);
    };

    const { data, isLoading, isError } = useQuery(searchOptions(queryStr));

    return (
    <div className="w-full my-10 px-2 md:px-8  lg:px-20">
        <h1 className="text-1xl px-2">Searh results for query: "{queryStr}"</h1>
        <div className="py-8 border-b flex justify-between items-center px-2">
            <SearchBar onSearch={handleMainSearch} className="w-96"/>
        </div>
        {isError?
            <h2 className="text-1xl px-2">There is no results for query "{queryStr}"</h2>
        :
            data
            ?
                <div className="card-container">
                {isLoading?
                        [0,1,2,3].map(v => <SkeletonCard /> )
                    :
                        data.map(v=><AnimeCard key={v.id} data={v} />)
                }
                </div>
            :
                <h2 className="text-1xl px-2">There is no results for query "{queryStr}"</h2>
        }
    </div>);
}


export default Search;