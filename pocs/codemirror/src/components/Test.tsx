import React, {useState} from "react";

interface Something {
    val: string;
}

const useMyHook = (): Something => {
    const [something, setSomething] = useState<Something>({val: "hello"});
    return something;
}

export function Test() {

    const x = useMyHook();

    return <p style={{color: "hotpink"}}>hi: {x.val}</p>
}