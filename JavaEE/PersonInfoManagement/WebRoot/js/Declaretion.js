function logout()
{
	$("#logout").click(function(){
        $.ajax({
          type: "post",
          url:  "ajax/logout.action",
          dataType: "json",
          beforeSend: 
            function(){
              $("#dialog4").modal("show");
            },
          success: 
            function(jsondata){
              window.location.href = "login.html";
            } 
        }); 
      });
}
function AddAuthor()
{
      $("#add").click(function(){
		  var table = $("#authorinfo tbody");
		  var rows = table.children("tr");
		  if (rows.length == 4) {
			  return $("#dialog1").modal("show");
		  }
		  var node = rows.eq(0);
		  var temp = node.clone();
		  temp.children("td").eq(0).find("input").val("");
          temp.children("td").eq(1).find("input").val("");
          temp.children("td").eq(2).find("select").val("");
		  var row = "<tr>";
		  var text = temp.html();
		  row = row + text + "</tr>";
		  table.append(row);
		  DeleteAuthor();
      });
}
function DeleteAuthor() {
	var obj = $("button[class='btn btn-danger']");
	var length = obj.size();
	length = length-1;
	var node = obj[length];
	$(node).click(function(){
 		var row = $(node).parent().parent();
		if (length != 0) {
			$(row).remove();
		} else {
			var test = $(row).children("td");
			$(test).eq(0).find("input").val("");
			$(test).eq(1).find("input").val("");
		}
	});
}