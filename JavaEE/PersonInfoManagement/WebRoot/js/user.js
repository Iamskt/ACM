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

function init(table, obj) {
	var size = obj.length;
	var tmp = $("#user tbody");
	for (var i = 0; i < size; i++) {
		var node = button();
		table.fnAddData([
			obj[i].salaryid,
			obj[i].username,
			obj[i].department,
			node
		]);
		var v1 = $("#user tbody").find("tr").eq(i);
		v1.attr("id", obj[i].id);
	}
}

function deal(obj) {
	pane1(obj);
	pane2(obj);
	pane3(obj[0].subject);
	pane4(obj[0].degree);
	pane5(obj[0].workexperience);
	pane6(obj[0].partjob);
	pane7(obj[0].honor);
}
function pane1(obj) {
	var place = ["北京", "上海", "重庆", "天津", "黑龙江", "吉林", "辽宁", "河北", "河南", "陕西", "山西", "甘肃", "宁夏", "新疆", "西藏", "四川", "山东", "湖北", "湖南", "江苏", "江西", "安徽", "海南", "台湾", "广东", "浙江", "广西", "云南", "贵州", "内蒙古", "青海", "福建", "香港", "澳门", "其他"];
	var hometown = place[obj[0].Teacherinfomation.hometown];
	$("#teachername2").text(obj[0].teacher.userName);
	$("#teacherId2").text(obj[0].user.username);
	$("#shenfenzheng").text(obj[0].Teacherinfomation.identityId);
	$("#birthday").text(obj[0].Teacherinfomation.birthday);
	$("#zhengzhi").text(obj[0].Teacherinfomation.political);
	$("#mingzu").text(obj[0].Teacherinfomation.ethnic);
	$("#jiguan").text(hometown);
}
function pane2(obj) {
	$("#duty").text(obj[0].Teacherinfomation.administrativeDuty);
	$("#title").text(obj[0].Teacherinfomation.title);
	$("#institute").text(obj[0].college);
	$("#department4").text(obj[0].teacher.department);
	$("#telAdd").text(obj[0].Teacherinfomation.communicationAddress);
	$("#area").text(obj[0].Teacherinfomation.researchDirection);
	$("#workAdd").text(obj[0].Teacherinfomation.officeAddress);
	$("#phone").text(obj[0].Teacherinfomation.telePhone);
	$("#mobile").text(obj[0].Teacherinfomation.officePhone);
	var node = obj[0].Teacherinfomation;
	var table = $("#mail tbody");
	if (node.mail1 != null) {	
		table.append("<tr><td><span class=\"input-large uneditable-input\">"+node.mail1+"</span></td></tr>");
	} 
	if (node.mail2 != null) {
		table.append("<tr><td><span class=\"input-large uneditable-input\">"+node.mail2+"</span></td></tr>");	
	}
	if (node.mail3 != null) {
		table.append("<tr><td><span class=\"input-large uneditable-input\">"+node.mail3+"</span></td></tr>");
	}
}	
function pane3(obj) {
	var table = $("#table1 tbody");
	for (var i = 0; i < obj.length; i ++) {
		var tr = "<tr>";
		tr += "<td>" + obj[i].subjectName + "</td>";
		tr += "<td>" + obj[i].subjection + "</td>";
		tr += "</tr>";
		table.append(tr);
	}
}
function pane4(obj) {
	var table = $("#table2 tbody");
	for (var i = 0; i < obj.length; i ++) {
		var tr = "<tr>";
		tr += "<td>" + obj[i].degreename + "</td>";
		tr += "<td>" + obj[i].startTime + "</td>";
		tr += "<td>" + obj[i].endTime + "</td>";
		tr += "<td>" + obj[i].graduationSchool + "</td>";
		tr += "<td>" + obj[i].schoolLevel + "</td>";
		tr += "<td>" + obj[i].specialty + "</td>";
		tr += "<td>";
		if (obj[i].highestDegree == false) {
			tr += "是";
		} else {
			tr += "否";
		}
		tr += "</tr>";
		table.append(tr);
	}
}
function pane5(obj) {
	var table = $("#table3 tbody");
	for (var i = 0; i < obj.length; i ++) {
		var tr = "<tr>";
		tr += "<td>" + obj[i].workSituation + "</td>";
		tr += "<td>" + obj[i].department + "</td>";
		tr += "<td>" + obj[i].startTime + "</td>";
		tr += "<td>" + obj[i].endTime + "</td>";
		tr += "</tr>";
		table.append(tr);
	}
}
function pane6(obj) {
	var table = $("#table4 tbody");
	for (var i = 0; i < obj.length; i ++) {
		var tr = "<tr>";
		tr += "<td>" + obj[i].partJobName + "</td>";
		tr += "<td>" + obj[i].startTime + "</td>";
		tr += "<td>" + obj[i].endTime + "</td>";
		tr += "</tr>";
		table.append(tr);
	}
}
function pane7(obj) {
	var table = $("#table5 tbody");
	for (var i = 0; i < obj.length; i ++) {
		var tr = "<tr>";
		tr += "<td>" + obj[i].honorName + "</td>";
		tr += "<td>" + obj[i].achieveTime + "</td>";
		tr += "<td>" + obj[i].batch + "</td>";
		tr += "<td>";
		if (obj[i].level == 0) {
			tr += "校级";
		} else if (obj[i].level == 1) {
			tr += "市级";
		} else if (obj[i].level == 2) {
			tr += "省级";
		} else if (obj[i].level == 3) {
			tr += "国际级";
		}
		tr += "</td>";
		tr += "</tr>";
		table.append(tr);
	}
}

function close() {
	$("#close").click(function() {
		$("#table1 tbody").empty();
		$("#table2 tbody").empty();
		$("#table3 tbody").empty();
		$("#table4 tbody").empty();
		$("#table5 tbody").empty();
	})
}
