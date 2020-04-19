
function ToLink(url)
{
	window.location.href=url;
}

//hàm chọn dữ liệu
function GetSelected() {
	//Reference the Table.
	var grid = document.getElementById("table.data");

	//Reference the CheckBoxes in Table.
	var checkBoxes = document.getElementsByName("checkboxrow");

	//Loop through the CheckBoxes.
	for (var i = 0; i < checkBoxes.length; i++) {
		var color = "white";
		if (checkBoxes[i].checked) {
			color = "yellow";
		}

		var row = checkBoxes[i].parentNode.parentNode;
		for (var j = 0; j < row.cells.length; j++) {
			row.cells[j].style.backgroundColor = color;
		}
	}

}