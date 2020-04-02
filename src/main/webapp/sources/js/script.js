function aircraftsPageAlert() {

    var aircraftCapacity = document.getElementById("text-box-2").value;
    var bordNumber = document.getElementById("text-box-3").value;
    var mess = "is not a number";

    if (aircraftCapacity != (aircraftCapacity - aircraftCapacity % 1) || aircraftCapacity == "") {
        document.getElementById("alert_1").innerHTML = "Capacity must be an integer number bigger than zero!!!";
        $("#alertMessage").modal('show');
        return;
    }

    document.getElementById("add-aircraft-form").submit();
}