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