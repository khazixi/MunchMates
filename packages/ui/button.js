"use strict";
"use client";
exports.__esModule = true;
exports.Button = void 0;
function Button() {
    return (<button onClick={function () {
            // eslint-disable-next-line no-alert -- alert is being used for demo purposes only
            alert("booped");
        }} type="button">
      Boop
    </button>);
}
exports.Button = Button;
