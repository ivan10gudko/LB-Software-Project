// ~/components/CollapsibleSection.tsx
import { type QueryKey, type QueryFunction } from "@tanstack/react-query";
import ArrowDropDownRoundedIcon from '@mui/icons-material/ArrowDropDownRounded';
import { type ReactNode } from "react";
import { useCollapsibleList } from "~/hooks/useCallableList";
import CollapsibleSectionSkeleton from "./ColapsableSectionSceleton";


// Props схожі на Варіант 1
type CollapsibleSectionProps<T, K extends string | number> = {
    title: string|React.ReactNode;
    queryKey: QueryKey;
    queryFn: QueryFunction<T[]>;
    getItemKey: (item: T) => K;
    renderItem: (item: T) => ReactNode;
};

function CollapsibleSection<T, K extends string | number>({
    title,
    queryKey,
    queryFn,
    renderItem,
    getItemKey
}: CollapsibleSectionProps<T, K>) {

    const {
        isOpen,
        toggleOpen,
        alwaysVisibleItems,
        collapsibleItems,
        isPending,
        error
    } = useCollapsibleList<T>({ queryKey, queryFn });

    if (isPending) {
        return <CollapsibleSectionSkeleton title={title} />;
    };
    if (error) return <div className="p-10 text-red-500">Error loading {title}.</div>;

    return (
        <div className="w-full px-2 md:px-8 lg:px-20">
            <div className="mt-10 border-b flex justify-between items-center px-2">
                <h3 className="text-2xl cursor-pointer" onClick={toggleOpen}>
                    {title}
                </h3>
                <button
                    onClick={toggleOpen}
                    className="p-1 rounded-full hover:bg-gray-100 transition-colors cursor-pointer"
                    aria-expanded={isOpen}
                    aria-controls={`list-container-${title}`}
                    aria-label={isOpen ? "Collapse list" : "Expand list"}
                >
                    <ArrowDropDownRoundedIcon sx={{ fontSize: 40 }} className={`dropdown ${isOpen ? "open" : ""}`} />
                </button>
            </div>
            <div className="w-full grid gap-y-6 xl:gap-y-10 grid-cols-2 md:grid-cols-4 xl:grid-cols-5 grid-rows-1 overflow-hidden 2xl:grid-cols-6 flex-wrap gap-6 py-10 justify-between">
                {alwaysVisibleItems.map((item) => (
                    <div key={getItemKey(item)}>
                        {renderItem(item)}
                    </div>
                ))}
                {isOpen ? collapsibleItems.map((item) => (
                    <div key={getItemKey(item)}>
                        {renderItem(item)}
                    </div>
                )) : null}
            </div>
        </div>
    );
};

export default CollapsibleSection;