var debounceMap = new Map();
var delay = 1000;

$("#tbody-stock tr").on("click", function(){
    /**
     * 1. 如果 Map 中不存在, 註冊一個倒數, 倒數結束後執行更新, 並從 Map 中移除
     * 2. 如果已經存在, 重新倒數, 倒數結束後執行更新, 並從 Map 中移除
     */
    if(!debounceMap.has($(this).children('td').html())){
        debounceMap.set($(this).children('td').html(), 
                        setTimeout(() => { 
                            console.log("Update1");
                            debounceMap.delete($(this).children('td').html());
                        }, delay));
    } else {
        clearTimeout(debounceMap.get($(this).children('td').html()));
        debounceMap.set($(this).children('td').html(), 
        setTimeout(() => { 
            console.log("Update2");
            debounceMap.delete($(this).children('td').html());
        }, delay));
    }
})

// TODO:
//      倒數結束時與原先資料進行比對, 若資料有改變, 則發送 Update API 給後端