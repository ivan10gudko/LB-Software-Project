import React from 'react';

interface InputProps {
    children?: string;
    name: string;
    type?: React.HTMLInputTypeAttribute;
    defaultValue?: string | number;
    pattern?: string;
    handleChange: (value: string) => void;
    error?: string | boolean | null;
}

const Input: React.FC<InputProps> = ({
    children,
    name,
    type = "text",
    defaultValue,
    pattern,
    handleChange,
    error,
}) => {
    return (
        <div className="relative">
            <input
                className={
                    "peer p-3 border-gray-300 border rounded-md w-full my-3 placeholder:text-sm placeholder:text-slate-600 focus:outline-0 focus:border-amber-200" +
                    (error ? "text-red-500 border-red-500" : "")
                }
                type={type}
                name={name}
                defaultValue={defaultValue}
                placeholder={children}
                pattern={pattern}
                onChange={(e) => handleChange(e.target.value)}
            />
            <span className='block peer-placeholder-shown:hidden absolute text-xs peer-focus:text-amber-300 top-0 left-4 bg-white px-2'>{name}</span>

            {error && typeof error === 'string' && (
                <p className="text-red-500 absolute top-full bg-white w-full py-3 px-4 rounded border z-30 border-red-500">
                    ⛔ {error}
                </p>
            )}
        </div>
    );
};

export default Input;