import { useState } from "react";
import SearchIcon from "@mui/icons-material/Search";
import { useNavigate } from "react-router";

const SearchBar: React.FC<{}> = ({}) => {
    const [value, setValue] = useState<string>("");
    const [error, setError] = useState<string | null>(null);
    const navigate = useNavigate();

    function handleSubmit(e: { preventDefault: () => void }) {
        e.preventDefault();

        if (value.trim() && value.length >= 3) {
            navigate(`/search?query=${encodeURIComponent(value)}`);
            setError("");
            setValue("");
        } else {
            setError("Length should be at least  3");
        }
    }

    function handleChange(e: React.ChangeEvent<HTMLInputElement>) {
        setValue(e.target.value);
        setError(null);
    }

    return (
        <form onSubmit={handleSubmit} className="relative border-black/60 border rounded-lg flex items-center">
            <input
                name="Search Input"
                id="SearchInput"
                type="search"
                placeholder="Search..."
                className="border-black/60 p-2 rounded-l-lg w-20 md:w-36 lg:w-48"
                value={value}
                onChange={handleChange}
            />
            {error && (<span className="text-red-700 bg-white px-3 py-2 rounded-b-md border-red-700 border y-2 absolute w-full left-0 bottom-0 translate-y-18 md:translate-y-9">{error}</span>)}
            <button type="submit" onClick={handleSubmit} className="px-1 md:px-4">
                {" "}<SearchIcon />
            </button>
        </form>
    );
};

export default SearchBar;
