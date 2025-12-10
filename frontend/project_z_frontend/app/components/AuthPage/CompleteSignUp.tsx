import { useState } from "react";
import Input from "./Input";
import Separator from "./Separator";
import SocialMediaBlock from "./SocialMediaBlock";
import Button from "../Button";

interface Props{
    setLogin: ()=>void;
}


const SignupForm : React.FC<Props> = ({setLogin})=> {
    const [name,setName] = useState<string>("")

    return (
    <div className="max-w-md w-full bg-white border-slate-200 shadow-lg py-6 px-8 rounded font-normal">
        <h2 className="text-amber-300 text-2xl font-medium w-full text-center mb-5">Complete Sign Up </h2>
        <Input type="text" name="Username" handleChange={(v)=>setName(v)}>Name</Input>
        <Button type="fill" className="w-full py-3 font-medium text-xl my-2" bgColor="var(--color-amber-300)" color="white ">Save</Button>
    </div> );
}

export default SignupForm;