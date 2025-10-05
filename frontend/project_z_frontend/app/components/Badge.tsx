interface Props{
    children: string,
    color?:string,
    size?: "lg" | "md" | "sm",

}

const Badge: React.FC<Props> = ({children, color,size="md"})=>{
    let styles:string;
    if(size=="lg"){
        styles = color ?"py-2 px-5 text-white flex w-fit rounded-xl text-md hover:opacity-80 ":"py-1 px-3 text-white flex w-fit rounded-lg text-xs border border-white hover:opacity-80";
    }else if(size="sm"){
        styles =color ? "py-1 px-3 text-white flex w-fit rounded-lg text-xs hover:opacity-80 ":"py-1 px-3 text-white flex w-fit rounded-lg text-xs border border-white hover:opacity-80";
    }else{
        styles = color ? "py-2 px-5 text-white flex w-fit rounded-lg hover:opacity-80" : "py-2 px-4 text-white flex w-fit rounded-lg border border-white hover:opacity-80"
    }

    return(
            <div className={styles} style={{backgroundColor:color}}>{children}</div>
        );
}
export default Badge;
