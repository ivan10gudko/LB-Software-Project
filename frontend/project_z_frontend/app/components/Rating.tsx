import StarIcon from '@mui/icons-material/Star';

interface Props{
    children: number,
}

const Rating: React.FC<Props> = ({children})=>{
    return (
        <span className='flex gap-2'>
            <StarIcon className='text-amber-300'/>
            <span>{children} / 10</span>
        </span>
    );
};

export default Rating;