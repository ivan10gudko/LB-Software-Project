import { Suspense, useEffect } from "react";
import HeroSection from "~/components/Home/HeroSection";
import HeroSkeleton from "~/components/Home/HeroSkeleton";
import Loader from "~/components/Home/Loader";


const Home : React.FC = ()=> {

    return (
    <>
        <Suspense fallback={<HeroSkeleton />}>
            <HeroSection />
        </Suspense>
    </>
    );
}

export default Home;