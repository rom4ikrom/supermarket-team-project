//Restricts input for the given textbox to the given inputFilter
$(function(){
	
	setInputFilter(document.getElementById("cardNumber"), function(value) {
		value = /^[0-9\s]*$/.test(value);
		return value;
	});

	setInputFilter(document.getElementById("expMonth"), function(value) {
		return /^-?\d*$/.test(value)
	});

	setInputFilter(document.getElementById("expYear"), function(value) {
		return /^-?\d*$/.test(value)
	});

	setInputFilter(document.getElementById("cvv"), function(value) {
		return /^-?\d*$/.test(value)
	});
	
	function setInputFilter(textbox, inputFilter) {
		["input", "keydown", "keyup", "mousedown", "mouseup", "select", "contextmenu", "drop"].forEach(function(event) {
			textbox.addEventListener(event, function() {
				if (inputFilter(this.value)) {
					this.oldValue = this.value;
					this.oldSelectionStart = this.selectionStart;
					this.oldSelectionEnd = this.selectionEnd;
				} else if (this.hasOwnProperty("oldValue")) {
					this.value = this.oldValue;
					this.setSelectionRange(this.oldSelectionStart, this.oldSelectionEnd);
				}
			});
		});
	}
	
});



