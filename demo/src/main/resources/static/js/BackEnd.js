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

            $("#tr-tfoot-stock").append("<td>$ "+sum+"</td>");
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
        data: $("#form-insert").serialize(),
        dataType: "JSON",
        success: function(json){
            if(json.state == 200){
                alert("新增資料成功");
            } else {
                alert("新增資料失敗");
            }
        },
        error: function(xhr){
            alert("未知的錯誤\n" + xhr.status);
        }
    });
});