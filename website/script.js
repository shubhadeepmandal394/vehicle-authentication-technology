function validateForm() {
  var x = document.forms["myForm"]["first_name"].value;
  if (x == "") {
    alert("Name must be filled out");
    return false;
  }
}