// 限制輸入字元
function alphabetAndNumberOnlyFilter(e){
    e.value = e.value.replace(/[^A-Z0-9]/g, '');
}