function jiguan() {
	var place = ["北京", "上海", "重庆", "天津", "黑龙江", "吉林", "辽宁", "河北", "河南", "陕西", "山西", "甘肃", "宁夏", "新疆", "西藏", "四川", "山东", "湖北", "湖南", "江苏", "江西", "安徽", "海南", "台湾", "广东", "浙江", "广西", "云南", "贵州", "内蒙古", "青海", "福建", "香港", "澳门", "其他"];
  	for (var i = 0; i < place.length; i++) {
    	$("#jiguan").append("<option value=" + i + ">" + place[i] + "</option>");
    }
}
function logout() {
	$("#logout").click(function() {
		$.ajax({
			type: "post",
			url: "ajax/logout.action",
			dataType: "json",
			beforeSend: function() {
				$("#dialog4").modal("show");
			},
			success: function(jsondata) {
				window.location.href = "login.html";
			}
		});
	});
}
function pane1(obj) {
	Deletemail();
	var place = ["北京", "上海", "重庆", "天津", "黑龙江", "吉林", "辽宁", "河北", "河南", "陕西", "山西", "甘肃", "宁夏", "新疆", "西藏", "四川", "山东", "湖北", "湖南", "江苏", "江西", "安徽", "海南", "台湾", "广东", "浙江", "广西", "云南", "贵州", "内蒙古", "青海", "福建", "香港", "澳门", "其他"];
	$("#teachername").text(obj[0].name);
	$("#teacherId").text(obj[0].user);
	$("#shenfenzheng").attr("value", obj[0].Teacherinfomation.identityId);
	$("#birthday").attr("value", obj[0].Teacherinfomation.birthday);
	$("#zhengzhi").attr("value", obj[0].Teacherinfomation.political);
	$("#mingzu").attr("value", obj[0].Teacherinfomation.ethnic);
	$("#jiguan").attr("text", obj[0].Teacherinfomation.hometown);
	var node = $("#jiguan").children("option").eq(obj[0].Teacherinfomation.hometown);
	node.attr("selected", true);
	var parent = node.parent().parent();
	var node1 = parent.children("div").children("a").children("span");
	node1.text(place[obj[0].Teacherinfomation.hometown]);
	$("#submit1").click(function() {
		var params = {
			username: $("#teachername").val(),
			teacherId: $("#teacherId").val(),
			shenfenzheng: $("#shenfenzheng").val(),
			birthday: $("#birthday").val(),
			zhengzhi: $("#zhengzhi").val(),
			mingzu: $("#mingzu").val(),
			jiguan: $("#jiguan").val()
		};
		$.ajax({
			type: "post",
			url: "ajax/personinfo.action",
			dataType: "json",
			data: params,
			success: function(jsondata) {
				$("#dialog1").modal("show");
			}
		});
	});
}

function Deletemail() {
	var obj = $("#mail button[class='btn btn-danger']");
	var length = obj.size();
	length = length - 1;
	var node = obj.eq(length);
	$(node).click(function() {
		var row = $(node).parent().parent();
		if (length != 0) {
			$(row).remove();
		} else {
			var test = $(row).children("td");
			$(test).eq(0).find("input").attr("value", "");
		}
	});
}

function pane2(obj) {
	$("#duty").attr("value", obj[0].Teacherinfomation.administrativeDuty);
	$("#title").attr("value", obj[0].Teacherinfomation.title);
	$("#institute").text(obj[0].college);
	$("#department").attr("value", obj[0].department);
	$("#telAdd").attr("value", obj[0].Teacherinfomation.communicationAddress);
	$("#area").attr("value", obj[0].Teacherinfomation.researchDirection);
	$("#workAdd").attr("value", obj[0].Teacherinfomation.officeAddress);
	$("#phone").attr("value", obj[0].Teacherinfomation.telePhone);
	$("#mobile").attr("value", obj[0].Teacherinfomation.officePhone);
	if (obj[0].Teacherinfomation.mail1 != "") {
		var mail1 = $("#mail tbody").children("tr").eq(0).children("td").eq(0).find("input");
		$(mail1).attr("value", obj[0].Teacherinfomation.mail1);
	}
	if (obj[0].Teacherinfomation.mail2 != "") {
		addmail();
		var mail2 = $("#mail tbody").children("tr").eq(1).children("td").eq(0).find("input");
		$(mail2).attr("value", obj[0].Teacherinfomation.mail2);
	}
	if (obj[0].Teacherinfomation.mail3 != "") {
		addmail();
		var mail3 = $("#mail tbody").children("tr").eq(2).children("td").eq(0).find("input");
		$(mail3).attr("value", obj[0].Teacherinfomation.mail3);
	}

	$("#addemail").click(function() {
		addmail();
	});
	$("#submit2").click(function() {
		var table = $("#mail tbody");
		var rows = table.children("tr");
		var v1 = rows.eq(0).children("td").eq(0).find("input").val();
		var v2 = rows.eq(1).children("td").eq(0).find("input").val();
		var v3 = rows.eq(2).children("td").eq(0).find("input").val();
		var params = {
			duty: $("#duty").val(),
			title: $("#title").val(),
			institute: $("#institute").val(),
			department: $("#department").val(),
			telAdd: $("#telAdd").val(),
			area: $("#area").val(),
			workAdd: $("#workAdd").val(),
      phone: $("#phone").val(),
      mobile: $("#mobile").val(),
      mail1: v1,
      mail2: v2,
      mail3: v3
    };
    $.ajax({
      type: "post",
      url: "ajax/Officeinfo.action",
      dataType: "json",
      data: params,
      success: function(jsondata) {
        $("#dialog1").modal("show");
      }
    });
  });
}

function addmail() {
  var table = $("#mail tbody");
  var rows = table.children("tr");
  length = rows.length;
  if (length == 3) {
    return $("#dialog2").modal("show");
  }
  var temp = rows.eq(0);
  var node = temp.clone();
  node.children("td").eq(0).find("input").val("");
  var row = "<tr>";
  var text = node.html();
  row = row + text + "</tr>";
  table.append(row);
  Deletemail();
}

//一下为table1
function showtable1(obj) {
  var node = obj;
  var length = obj.length;
  var table = $("#table1 tbody");
  for (var i = 0; i < length; i++) {
    var row = table.children("tr").eq(i);
    row.attr("id", node[i].subjectId);
    row.children("td").eq(0).find("input").attr("value", node[i].subjectName);
    row.children("td").eq(1).find("input").attr("value", node[i].subjection);
    if (i != length - 1) {
      addnode1();
    }
  }
}

function addtable1() {
  $("#add1").click(function() {;
    addnode1();
  })
}

function addnode1() {
  var table = $("#table1 tbody");
  var rows = table.children("tr");
  length = rows.length;
  var node1 = rows.eq(0);
  var node = node1.clone();
  node.children("td").eq(0).find("input").attr("value", "");
  node.children("td").eq(1).find("input").attr("value", "");
  var row = "<tr>";
  var text = node.html();
  row = row + text + "</tr>";
  table.append(row);
  deletetable1();
  savenode1();
}

function savenode1() {
  var rows = $("#table1 button[class='btn btn-info']");
  var length = rows.length - 1;
  var row = rows.eq(length);
  $(row).click(function() {
    var node = row.parent().parent();
    var v1 = node.children("td").eq(0).find("input").val();
    var v2 = node.children("td").eq(1).find("input").val();
    var v3 = node.attr("id");
    var params = {
      xuekename: v1,
      xuekelevel: v2,
      tid: v3
    };
    $.ajax({
      type: "post",
      url: "ajax/xueke.action",
      dataType: "json",
      data: params,
      success: function(jsondata) {
        $("#dialog1").modal("show");
        var obj = $.parseJSON(jsondata);
        node.attr("id", obj[0].tid);
      }
    });
  });
}

function deletetable1() {
  var obj = $("#table1 button[class='btn btn-danger']");
  var length = obj.size();
  length = length - 1;
  var node = obj[length];
  $(node).click(function() {
    var row = $(node).parent().parent();
    var id = row.attr("id");
    if (id != null) {
      var params = {
        tid: id
      };
      $.ajax({
        type: "post",
        url: "ajax/delxueke.action",
        dataType: "json",
        data: params,
        success: function(jsondata) {
          $("#dialog3").modal("show");
        }
      });
    }
    if (length != 0) {
      $(row).remove();
    } else {
      var test = $(row).children("td");
      $(test).eq(0).find("input").attr("value", "");
      $(test).eq(1).find("input").attr("value", "");
    }
  });
}

/*next is table2*/
function showtable2(obj) {
  var node = obj;
  var length = obj.length;
  var table = $("#table2 tbody");
  for (var i = 0; i < length; i++) {
    var row = table.children("tr").eq(i);
    row.attr("id", node[i].id);
    row.children("td").eq(0).find("input").attr("value", node[i].degreename);
    row.children("td").eq(1).find("input").attr("value", node[i].startTime);
    row.children("td").eq(2).find("input").attr("value", node[i].endTime);
    row.children("td").eq(3).find("input").attr("value", node[i].graduationSchool);
    row.children("td").eq(4).find("input").attr("value", node[i].schoolLevel);
    row.children("td").eq(5).find("input").attr("value", node[i].specialty);
    var v6 = 0;
    if (node[i].highestDegree == true) {
      v6 = 1;
    }
    row.children("td").eq(6).children("div").find("select").attr("value", v6);
    if (i != length - 1) {
      addnode2();
    }
  }
}

function addtable2() {
	$("#add2").click(function() {
		addnode2();
	})
}

function savenode2() {
	var rows = $("#table2 button[class='btn btn-info']");
	var length = rows.length - 1;
	var row = rows.eq(length);
	$(row).click(function() {
		var node = row.parent().parent();
		var v1 = node.children("td").eq(0).find("input").val();
		var v2 = node.children("td").eq(1).find("input").val();
		var v3 = node.children("td").eq(2).find("input").val();
		var v4 = node.children("td").eq(3).find("input").val();
		var v5 = node.children("td").eq(4).find("input").val();
		var v6 = node.children("td").eq(5).find("input").val();
		var v7 = node.children("td").eq(6).find("select").val();
		var v8 = node.attr("id");
		var params = {
			xuewei: v1,
			readtime: v2,
			endtime: v3,
			graduatedschool: v4,
			schoollevel: v5,
			area: v6,
			highest: v7,
			tid: v8
		};
		$.ajax({
			type: "post",
			url: "ajax/xuewei.action",
			dataType: "json",
			data: params,
			success: function(jsondata) {
				$("#dialog1").modal("show");
				var obj = $.parseJSON(jsondata);
				node.attr("id", obj[0].tid);
			}
		});
	});
}

function addnode2() {
	var table = $("#table2 tbody");
	var rows = table.children("tr");
	length = rows.length + 1;
	var node1 = rows.eq(0);
	var node = node1.clone();
	node.children("td").eq(0).find("input").attr("value", "");
	node.children("td").eq(1).find("input").attr("value", "12/08/13");
	node.children("td").eq(2).find("input").attr("value", "12/08/13");
	node.children("td").eq(3).find("input").attr("value", "");
	node.children("td").eq(4).find("input").attr("value", "");
	node.children("td").eq(5).find("input").attr("value", "");
	node.children("td").eq(6).find("select").attr("value", 0);
	var row = "<tr>";
	var text = node.html();
	row = row + text + "</tr>";
	table.append(row);
	deletetable2();
	savenode2();
}

function deletetable2() {
	var obj = $("#table2 button[class='btn btn-danger']");
	var length = obj.size();
	length = length - 1;
	var node = obj[length];
	$(node).click(function() {
		var row = $(node).parent().parent();
		var id = row.attr("id");
		if (id != null) {
			var params = {
				tid: id
			};
			$.ajax({
				type: "post",
				url: "ajax/delwuewei.action",
				dataType: "json",
				data: params,
				success: function(jsondata) {
					$("#dialog3").modal("show");
				}
			});
		}
		if (length != 0) {
			$(row).remove();
		} else {
			var test = $(row).children("td");
			$(test).eq(0).find("input").attr("value", "");
			$(test).eq(1).find("input").attr("value", "");
			$(test).eq(2).find("input").attr("value", "");
			$(test).eq(3).find("input").attr("value", "");
			$(test).eq(4).find("input").attr("value", "");
			$(test).eq(5).find("input").attr("value", "");
			$(test).eq(6).find("select").attr("value", 0);
		}
	});
}

/*涓�笅鏄痶able3*/
function showtable3(obj) {
	var node = obj;
	var length = obj.length;
	var table = $("#table3 tbody");
	for (var i = 0; i < length; i++) {
		var row = table.children("tr").eq(i);
		row.attr("id", node[i].id);
		row.children("td").eq(0).find("input").attr("value", node[i].workSituation);
		row.children("td").eq(1).find("input").attr("value", node[i].department);
		row.children("td").eq(2).find("input").attr("value", node[i].startTime);
		row.children("td").eq(3).find("input").attr("value", node[i].endTime);
		if (i != length - 1) {
			addnode3();
		}
	}
}

function addtable3() {
	$("#add3").click(function() {;
		addnode3();
	})
}

function addnode3() {
	var table = $("#table3 tbody");
	var rows = table.children("tr");
	length = rows.length + 1;
	var node1 = rows.eq(0);
	var node = node1.clone();
	node.children("td").eq(0).find("input").attr("value", "");
	node.children("td").eq(1).find("input").attr("value", "");
	node.children("td").eq(2).find("input").attr("value", "12/08/13");
	node.children("td").eq(3).find("input").attr("value", "12/08/13");
	var row = "<tr>";
	var text = node.html();
	row = row + text + "</tr>";
	table.append(row);
	deletetable3();
	savenode3();
}

function savenode3() {
	var rows = $("#table3 button[class='btn btn-info']");
	var length = rows.length - 1;
	var row = rows.eq(length);
	$(row).click(function() {
		var node = row.parent().parent();
		var v1 = node.children("td").eq(0).find("input").val();
		var v2 = node.children("td").eq(1).find("input").val();
		var v3 = node.children("td").eq(2).find("input").val();
		var v4 = node.children("td").eq(3).find("input").val();
		var v5 = node.attr("id");
		var params = {
			workSituation: v1,
			department: v2,
			startTime: v3,
			endTime: v4,
			tid: v5
		};
		$.ajax({
			type: "post",
			url: "ajax/Workexp.action",
			dataType: "json",
			data: params,
			success: function(jsondata) {
				$("#dialog1").modal("show");
				var obj = $.parseJSON(jsondata);
				node.attr("id", obj[0].tid);
			}
		});
	});
}

function deletetable3() {
	var obj = $("#table3 button[class='btn btn-danger']");
	var length = obj.size();
	length = length - 1;
	var node = obj[length];
	$(node).click(function() {
		var row = $(node).parent().parent();
		var id = row.attr("id");
		if (id != null) {
			var params = {
				tid: id
			};
			$.ajax({
				type: "post",
				url: "ajax/Delworkexp.action",
				dataType: "json",
				data: params,
				success: function(jsondata) {
					$("#dialog3").modal("show");
				}
			});
		}
		if (length != 0) {
			$(row).remove();
		} else {
			var test = $(row).children("td");
			$(test).eq(0).find("input").attr("value", "");
			$(test).eq(1).find("input").attr("value", "");
			$(test).eq(2).find("input").attr("value", "");
			$(test).eq(3).find("input").attr("value", "");
		}
	});
}

//涓�笅涓簍able4
function showtable4(obj) {
	var node = obj;
	var length = obj.length;
	var table = $("#table4 tbody");
	for (var i = 0; i < length; i++) {
		var row = table.children("tr").eq(i);
		row.attr("id", node[i].id);
		row.children("td").eq(0).find("input").attr("value", node[i].partJobName);
		row.children("td").eq(1).find("input").attr("value", node[i].startTime);
		row.children("td").eq(2).find("input").attr("value", node[i].endTime);
		if (i != length - 1) {
			addnode4();
		}
	}
}

function addtable4() {
	$("#add4").click(function() {;
		addnode4();
	})
}

function addnode4() {
	var table = $("#table4 tbody");
	var rows = table.children("tr");
	length = rows.length + 1;
	var node1 = rows.eq(0);
	var node = node1.clone();
	node.children("td").eq(0).find("input").attr("value", "");
	node.children("td").eq(1).find("input").attr("value", "12/08/13");
	node.children("td").eq(2).find("input").attr("value", "12/08/13");
	var row = "<tr>";
	var text = node.html();
	row = row + text + "</tr>";
	table.append(row);
	deletetable4();
	savenode4();
}

function savenode4() {
	var rows = $("#table4 button[class='btn btn-info']");
	var length = rows.length - 1;
	var row = rows.eq(length);
	$(row).click(function() {
		var node = row.parent().parent();
		var v1 = node.children("td").eq(0).find("input").val();
		var v2 = node.children("td").eq(1).find("input").val();
		var v3 = node.children("td").eq(2).find("input").val();
		var v4 = node.attr("id");
		var params = {
			partJobName: v1,
			startTime: v2,
			endTime: v3,
			tid: v4
		};
		$.ajax({
			type: "post",
			url: "ajax/partjob.action",
			dataType: "json",
			data: params,
			success: function(jsondata) {
				$("#dialog1").modal("show");
				var obj = $.parseJSON(jsondata);
				node.attr("id", obj[0].tid);
			}
		});
	});
}

function deletetable4() {
	var obj = $("#table4 button[class='btn btn-danger']");
	var length = obj.size();
	length = length - 1;
	var node = obj[length];
	$(node).click(function() {
		var row = $(node).parent().parent();
		var id = row.attr("id");
		if (id != null) {
			var params = {
				tid: id
			};
			$.ajax({
				type: "post",
				url: "ajax/delpartjob.action",
				dataType: "json",
				data: params,
				success: function(jsondata) {
					$("#dialog3").modal("show");
				}
			});
		}
		if (length != 0) {
			$(row).remove();
		} else {
			var test = $(row).children("td");
			$(test).eq(0).find("input").attr("value", "");
			$(test).eq(1).find("input").attr("value", "");
			$(test).eq(2).find("input").attr("value", "");
		}
	});
}

function showtable5(obj) {
  var node = obj;
  var length = obj.length;
  var table = $("#table5 tbody");
  for (var i = 0; i < length; i++) {
  	var row = table.children("tr").eq(i);
  	row.attr("id", node[i].id);
  	row.children("td").eq(0).find("input").attr("value", node[i].honorName);
  	row.children("td").eq(1).find("input").attr("value", node[i].achieveTime);
  	row.children("td").eq(2).find("input").attr("value", node[i].batch);
  	row.children("td").eq(3).find("select").attr("value", node[i].level);
  	if (i != length - 1) {
  		addnode5();
  	}
  }
}

function addtable5() {
	$("#add5").click(function() {;
		addnode5();
	})
}

function addnode5() {
	var table = $("#table5 tbody");
	var rows = table.children("tr");
	length = rows.length + 1;
	var node1 = rows.eq(0);
	var node = node1.clone();
	node.children("td").eq(0).find("input").attr("value", "");
	node.children("td").eq(1).find("input").attr("value", "12/08/13");
	node.children("td").eq(2).find("input").attr("value", "");
	node.children("td").eq(3).find("select").attr("value", 0);
	var row = "<tr>";
	var text = node.html();
	row = row + text + "</tr>";
	table.append(row);
	deletetable5();
	savenode5();
}

function savenode5() {
	var rows = $("#table5 button[class='btn btn-info']");
	var length = rows.length - 1;
	var row = rows.eq(length);
	$(row).click(function() {
		var node = row.parent().parent();
		var v1 = node.children("td").eq(0).find("input").val();
		var v2 = node.children("td").eq(1).find("input").val();
		var v3 = node.children("td").eq(2).find("input").val();
		var v4 = node.children("td").eq(3).find("select").val();
		var v5 = node.attr("id");
		var params = {
			honorName: v1,
			achieveTime: v2,
			batch: v3,
			level: v4,
			tid: v5
		};
		$.ajax({
			type: "post",
			url: "ajax/honor.action",
			dataType: "json",
			data: params,
			success: function(jsondata) {
				$("#dialog1").modal("show");
				var obj = $.parseJSON(jsondata);
				node.attr("id", obj[0].tid);
			}
		});
	});
}

function deletetable5() {
	var obj = $("#table5 button[class='btn btn-danger']");
	var length = obj.size();
	length = length - 1;
	var node = obj[length];
	$(node).click(function() {
		var row = $(node).parent().parent();
		var id = row.attr("id");
		if (id != null) {
			var params = {
				tid: id
			};
			$.ajax({
				type: "post",
				url: "ajax/delhonor.action",
				dataType: "json",
				data: params,
				success: function(jsondata) {
					$("#dialog3").modal("show");
				}
			});
		}
		if (length != 0) {
			$(row).remove();
		} else {
			var test = $(row).children("td");
			$(test).eq(0).find("input").attr("value", "");
			$(test).eq(0).find("input").attr("value", "");
			$(test).eq(0).find("input").attr("value", "");
			$(test).eq(0).find("select").attr("value", 0);
		}
	});
}

function alltable() {
	deletetable5();
	deletetable1();
	deletetable3();
	deletetable4();
	deletetable2();
	addtable1();
	addtable2();
	addtable3();
	addtable4();
	addtable5();
	savenode1();
	savenode2();
	savenode3();
	savenode4();
	savenode5();
}

function pane3(obj) {
	alltable();
	showtable1(obj[0].subject);
	showtable2(obj[0].degree);
	showtable3(obj[0].workexperience);
	showtable4(obj[0].partjob);
	showtable5(obj[0].honor);
}