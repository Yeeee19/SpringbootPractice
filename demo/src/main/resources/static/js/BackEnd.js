var debounceMap = new Map();
var delay = 8000;

// 載入時表格插入資料
$(document).ready(function(){
    $.ajax({
        url: "/stock/findall",
        type: "GET",
        data: "",
        dataType: "JSON",
        success: function(json){
            let list = json.data;
            let sum = 0;
            for(let i = 0; i < list.length; i++){
                let stock = '<tr>'
                          +     '<td>#{id}</td>'
                          +     '<td>'
                          +         '<input class="stock" maxlength="10" onkeyup="alphabetAndNumberOnlyFilter(this)" value="#{stock}">'
                          +     '</td>'
                          +     '<td>'
                          +         '<input class="tradeDate" type="date" max="2999-12-31" value="#{tradeDate}">'
                          +     '</td>'
                          +     '<td>'
                          +         '<input class="volume" type="number" value="#{volume}">'
                          +     '</td>'
                          +     '<td>'
                          +         '<input class="price" type="number" value="#{price}">'
                          +     '</td>'
                          + '</tr>'

                stock = stock.replace("#{id}", list[i].id);
                stock = stock.replace("#{stock}", list[i].stock);
                stock = stock.replace("#{tradeDate}", list[i].tradeDate);
                stock = stock.replace("#{volume}", list[i].volume);
                stock = stock.replace("#{price}", list[i].price);

                $("#tbody-stock").append(stock);
                sum += list[i].price;
            }

            $("#tr-tfoot-stock").append('<td id="sum">$ '+sum+'</td>');

            $("#tbody-stock tr").on("click", function(){
                if(!debounceMap.has($(this).children('td').html())){
                    debounceMap.set($(this).children('td').html(),
                                    setTimeout(() => {
                                        update(this);
                                        debounceMap.delete($(this).children('td').html());
                                    }, delay));
                    } else {
                        clearTimeout(debounceMap.get($(this).children('td').html()));
                        debounceMap.set($(this).children('td').html(),
                        setTimeout(() => {
                            update(this);
                            debounceMap.delete($(this).children('td').html());
                        }, delay));
                    }
            });
        },
        error: function(xhr){
            alert("未知的錯誤\n" + xhr.status);
        }
    });
});

// 新增資料
$("#btn-insert").click(function(){
    $.ajax({
        url: "/stock/add",
        type: "POST",
        data: "stock=" + $('#stock').val()
            + "&tradeDate=" + $('#tradeDate').val().replace(/-/g, "/")
            + "&volume=" + $('#volume').val()
            + "&price=" + $('#price').val(),
        dataType: "JSON",
        success: function(json){
            if(json.state == 200){
                //alert("新增資料成功");
                var id = parseInt( $("#tbody-stock tr").last().children('td').html() ) + 1;
                let stock = '<tr>'
                          +     '<td>'+ id +'</td>'
                          +     '<td>'
                          +         '<input class="stock" maxlength="10" onkeyup="alphabetAndNumberOnlyFilter(this)" value='+$("#stock").val()+'>'
                          +     '</td>'
                          +     '<td>'
                          +         '<input class="tradeDate" type="date" max="2999-12-31" value='+$("#tradeDate").val()+'>'
                          +     '</td>'
                          +     '<td>'
                          +         '<input class="volume" type="number" value='+$("#volume").val()+'>'
                          +     '</td>'
                          +     '<td>'
                          +         '<input class="price" type="number" value='+$("#price").val()+'>'
                          +     '</td>'
                          + '</tr>'

                $("#tbody-stock").append(stock);
                $("#sum").html('$ ' + (parseInt($("#sum").html().substring(2)) + parseInt($("#price").val())));

                $("#tbody-stock tr").last().on("click", function(){
                    if(!debounceMap.has($(this).children('td').html())){
                        debounceMap.set($(this).children('td').html(),
                                        setTimeout(() => {
                                            update(this);
                                            debounceMap.delete($(this).children('td').html());
                                        }, delay));
                    } else {
                        clearTimeout(debounceMap.get($(this).children('td').html()));
                        debounceMap.set($(this).children('td').html(),
                        setTimeout(() => {
                            update(this);
                            debounceMap.delete($(this).children('td').html());
                        }, delay));
                    }
                })

            } else {
                alert("新增資料失敗");
            }
        },
        error: function(xhr){
            alert("未知的錯誤\n" + xhr.status);
        }
    });
});

//更新資料
function update(obj){
    $.ajax({
            url: "/stock/update",
            type: "POST",
            data: "id=" + $(obj).children('td').html()
                + "&stock=" + $(obj).children('td').children('.stock').val()
                + "&tradeDate=" + $(obj).children('td').children('.tradeDate').val().replace(/-/g, "/")
                + "&volume=" + $(obj).children('td').children('.volume').val()
                + "&price=" + $(obj).children('td').children('.price').val(),
            dataType: "JSON",
            success: function(json){
                if(json.state == 200){
                    console.log("編號: " + $(obj).children('td').html() + " 更新成功");
                } else {
                    console.log("編號: " + $(obj).children('td').html() + " 更新失敗");
                }
            },
            error: function(xhr){
                alert("未知的錯誤\n" + xhr.status);
            }
    });
}
