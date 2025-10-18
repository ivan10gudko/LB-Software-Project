import { useQuery } from "@tanstack/react-query";
import { getTopAnimeList } from "~/services/MyAnimeList";
import AnimeCard, { type AnimeCardType } from "./AnimeCard";
import ArrowDropDownRoundedIcon from '@mui/icons-material/ArrowDropDownRounded';
import { useState } from "react";
import useWindowDimensions from "~/utils/useWindowDimensions";

const TopAnimeList: React.FC<{}> = ({})=>{
    const [isOpen,setIsOpen] = useState<boolean>(false);
    const windowSize = useWindowDimensions();
    
    const {isPending,data,error} = useQuery<AnimeCardType[]>({
        queryKey:["top_anime_list"],
        queryFn:getTopAnimeList
    });

    if(!data) return;

    let itemsInFirstRow;
    if(windowSize == 'xs' ||windowSize == 'sm' ){
        itemsInFirstRow = 2;
    }else if(windowSize == 'md' ||windowSize == 'lg' ){
        itemsInFirstRow = 4;
    }else if(windowSize =='xl'){
        itemsInFirstRow = 5;
    }else{
        itemsInFirstRow = 6;
    }

    // 2. Split the data into two parts without modifying the original array.
    const alwaysVisibleAnime = data?.slice(0, itemsInFirstRow);
    const collapsibleAnime = data?.slice(itemsInFirstRow);

    return  (
<>
    <div className="w-full border-y px-2 md:px-8 lg:px-20">
        <div className="mt-10 border-b flex justify-between items-center px-2">
            <h3 className="text-2xl  cursor-pointer" onClick={() => setIsOpen(open=>!open)}>Top anime this week </h3>
                <button
                    onClick={() => setIsOpen(open=>!open)}
                    className="p-1 rounded-full hover:bg-gray-100 transition-colors cursor-pointer"
                    aria-expanded={isOpen}
                    aria-controls="anime-list-container" // Links button to the content it controls
                    aria-label={isOpen ? "Collapse list" : "Expand list"}
                >
                    <ArrowDropDownRoundedIcon sx={{fontSize:40}} className={`dropdown ${isOpen ? "open":""}`}/>
                </button>
        </div>
        <div className="w-full grid gap-y-6 xl:gap-y-10 grid-cols-2 md:grid-cols-4 xl:grid-cols-5 grid-rows-1 overflow-hidden 2xl:grid-cols-6 flex-wrap gap-6 py-6 justify-between">
            {alwaysVisibleAnime.map((d)=><AnimeCard data={d} key={d.id}/>)}
            {isOpen ? collapsibleAnime.map((d)=><AnimeCard data={d} key={d.id}/>) : null}
        </div>
    </div>
</>
);
};

export default TopAnimeList;

