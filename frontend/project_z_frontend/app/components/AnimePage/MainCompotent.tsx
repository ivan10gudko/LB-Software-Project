import type { Anime } from "~/services/MyAnimeList.types";

interface Props{
    data: Anime
}
const MainComponent : React.FC<Props> = ({data}) => {
    return ( <div className="w-full h-screen bg-amber-300"></div> );
}

export default MainComponent;