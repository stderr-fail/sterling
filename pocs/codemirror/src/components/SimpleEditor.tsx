import React, {useMemo, useState} from "react";

import {basicSetup, EditorView} from "codemirror"
import {markdown} from "@codemirror/lang-markdown"
import {languages} from "@codemirror/language-data"

export function SimpleEditor() {
    const view = useMemo(() => {
        return new EditorView({
            doc: "Hello\n\n```javascript\nlet x = 'y'\n```",
            extensions: [
                basicSetup,
                markdown({codeLanguages: languages})
            ],
            parent: document.body
        });
    }, []);
    return <div>editor</div>
}
