import { Link } from "react-router";
import Input from "./Input";
import { useState } from "react";
import Button from "../Button";

import SocialMediaBlock from "./SocialMediaBlock";
import Separator from "./Separator";

interface Props{
    setSignup: ()=>void;
}

const LoginForm : React.FC<Props> = ({setSignup})=> {
    const [email,setEmail] = useState<string>("")
    const [password,setPassword] = useState<string>("")
    return (
    <div className="max-w-md w-full bg-white border-slate-200 shadow-lg py-8 px-8 rounded font-normal">
        <h2 className="text-amber-300 text-2xl font-medium w-full text-center mb-5" >Login</h2>
        <form>
            <Input type="text" name="Email or Username" handleChange={(v)=>setEmail(v)}>Email or Username</Input>
            <Input type="password" name="password" handleChange={(v)=>setPassword(v)}>Password</Input>
            <Button type="fill" className="w-full py-3 font-medium text-xl my-2" bgColor="var(--color-amber-300)" color="white ">Login</Button>
        </form>
        <div className="text-sm text-slate-500 mt-4">
            Don't have an accout? <span className="cursor-pointer text-amber-300 hover:text-amber-200" onClick={setSignup}>Sign Up</span>
        </div>
        <Separator> or </Separator>
        <SocialMediaBlock />
    </div> );
}

export default LoginForm;