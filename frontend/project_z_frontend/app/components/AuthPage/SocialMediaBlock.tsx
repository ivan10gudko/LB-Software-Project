import Button from "../Button"

import { FaFacebook, FaDiscord } from "react-icons/fa";
import { FcGoogle  } from "react-icons/fc";


const SocialMediaBlock: React.FC = ()=>{
    return(
    <div className="flex items-center justify-between flex-col gap-4 font-medium text-black/50">
        <Button type="outline" className="border-[1px] w-full flex">Continue with <FcGoogle size={32} className="mx-4" /></Button>
        <Button type="outline" className="border-[1px] w-full flex">Continue with <FaDiscord color="#5865F2" size={32} className="mx-4" /></Button>
        <Button type="outline" className="border-[1px] w-full flex">Continue with <FaFacebook color="#1877F2" size={32} className="mx-4"/></Button>
    </div>)
}
export default SocialMediaBlock