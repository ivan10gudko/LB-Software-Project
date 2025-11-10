import { useQuery, useSuspenseQuery } from "@tanstack/react-query";
import { useParams } from "react-router";
import MainComponent from "~/components/AnimePage/MainCompotent";
import Sidebar from "~/components/AnimePage/Sidebar";
import { getAnimeById } from "~/services/MyAnimeList";
import type { Anime } from "~/services/MyAnimeList.types";

const AnimePage : React.FC = () => {
    let { id } = useParams();
    const { isPending, error, data } = useQuery<Anime>({
            queryKey: ["anime-page",id],
            queryFn: async ()=>{
                const res = await getAnimeById(Number(id));
                console.log(res);
                return res;
            },
        });

    if (isPending) return 'Loading...'

    if (error) return 'An error has occurred: ' + error.message

    return (
        <div className="sm:flex sm:gap-8 mx-auto my-8 w-[90%] max-w-[1200px]">
            <Sidebar data={data} />
            <MainComponent data={data} />
        </div>
    )
}

export default AnimePage;