// image gallery
// init the state from the input
$(".checkbox").each(function () {
  if ($(this).find('input[type="checkbox"]').first().attr("checked")) {
    $(this).addClass('checkbox-checked');
  }
  else {
    $(this).removeClass('checkbox-checked');
  }
});

// sync the state to the input
$(".checkbox").on("click", function (e) {
  $(this).toggleClass('checkbox-checked');
  var $checkbox = $(this).find('input[type="checkbox"]');
  $checkbox.prop("checked",!$checkbox.prop("checked"))

  e.preventDefault();
});