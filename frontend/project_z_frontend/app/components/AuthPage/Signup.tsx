import { useState } from "react";
import Input from "./Input";
import Separator from "./Separator";
import SocialMediaBlock from "./SocialMediaBlock";
import Button from "../Button";

interface Props{
    setLogin: ()=>void;
}


const SignupForm : React.FC<Props> = ({setLogin})=> {
    const [email,setEmail] = useState<string>("")
    const [password,setPassword] = useState<string>("")
    const [confirmPassword,setConfirmPassword] = useState<string>("")
    
    return (
    <div className="max-w-md w-full bg-white border-slate-200 shadow-lg py-6 px-8 rounded font-normal">
        <h2 className="text-amber-300 text-2xl font-medium w-full text-center mb-5">Sign Up </h2>
        <Input type="email" name="Email or Username" handleChange={(v)=>setEmail(v)}>Email</Input>
        <Input type="email" name="Email or Username" handleChange={(v)=>setEmail(v)}>Name</Input>
        <Input type="password" name="Password" handleChange={(v)=>setPassword(v)}>Password</Input>
        <Input type="password" name="Confirm password" handleChange={(v)=>setConfirmPassword(v)}>Confirm password</Input>
        <Button type="fill" className="w-full py-3 font-medium text-xl my-2" bgColor="var(--color-amber-300)" color="white ">Sign Up</Button>
        <div className="text-sm text-gray-400">
            Already have an account? <span className="cursor-pointer text-amber-300 hover:text-amber-200 my-4" onClick={setLogin}>Log in</span>
        </div>
        <Separator> or </Separator>
        <SocialMediaBlock />
    </div> );
}

export default SignupForm;