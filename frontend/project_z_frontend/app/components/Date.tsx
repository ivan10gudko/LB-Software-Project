import CalendarTodayIcon from '@mui/icons-material/CalendarToday';

interface Props{
    children: string | React.ReactNode
}

const Date: React.FC<Props> = ({children})=>{
    return (<span className='flex gap-2'>
            <CalendarTodayIcon fontSize='small'/>
            <span>{children}</span>
        </span>);
}

export default Date;