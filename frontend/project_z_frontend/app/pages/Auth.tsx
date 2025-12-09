import { useState } from "react";
import { Link } from "react-router";
import LoginForm from "~/components/AuthPage/Login";
import SignupForm from "~/components/AuthPage/Signup";
import Logo from "~/components/Logo";

const Auth : React.FC = ()=> {
    const [isSignedUp,setIsSignedUp] = useState<boolean>(true);
    return (
    <div className="min-h-screen flex items-center justify-center p-4 bg-[url(/placeholder.jpg)]">
        <div className="absolute top-4 left-8"><Link to="/"><Logo /></Link></div>
        {isSignedUp ? <LoginForm setSignup={()=>setIsSignedUp(false)} /> : <SignupForm setLogin={()=>setIsSignedUp(true)} />}
    </div> );
}

export default Auth;