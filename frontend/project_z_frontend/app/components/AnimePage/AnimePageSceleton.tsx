import MainComponentSkeleton from "./MainComponentSceleton";
import SidebarSkeleton from "./SidebarSceleton";

const AnimePageSceleton : React.FC = ()=>{
    return <div className="sm:flex sm:gap-8 mx-auto my-8 w-[90%] max-w-[1200px] h-fit  pointer-events-none">
            <SidebarSkeleton/>
            <MainComponentSkeleton/>
        </div>
}

export default AnimePageSceleton;