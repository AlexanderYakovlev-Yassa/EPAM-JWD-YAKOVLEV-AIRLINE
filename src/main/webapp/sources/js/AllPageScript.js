/**
 * Scripts for header part of pages
 */

function clickOnUser() {
	var pageoffset = window.pageYOffset;
	$("#alertMessage").modal('show');
}

function dropDownPick(elementName1, elementValue1, elementName2, elementValue2) {
	
	var pageoffset = window.pageYOffset;
	 window.scrollTo(0,pageoffset);

    document.getElementById(elementName1).innerHTML = elementValue1;
    document.getElementById(elementName2).setAttribute("value", elementValue2);
}

function dropDownPick3(elementName1, elementValue1, elementName2, elementValue2, elementName3, elementValue3) {
	
	var pageoffset = window.pageYOffset;

    document.getElementById(elementName1).innerHTML = elementValue1;
    document.getElementById(elementName2).setAttribute("value", elementValue2);
    document.getElementById(elementName3).setAttribute("value", elementValue3);
}

function fillForm(userID, nickname, firstName, lastName, systemRoleID, systemRoleName, crewRoleID, crewRoleName) {

	document.getElementById("current-employee-id").setAttribute("value", userID);
	
    document.getElementById("current-employee-nickname").setAttribute("value", nickname);
    document.getElementById("current-employee-first-name").setAttribute("value", firstName);
    document.getElementById("current-employee-last-name").setAttribute("value", lastName);
    document.getElementById("current-employee-system-role-name").innerHTML = systemRoleName;
    document.getElementById("current-employee-system-role-id").setAttribute("value", systemRoleID);
    
    document.getElementById("current-employee-crew-role-name").innerHTML = crewRoleName;
    document.getElementById("current-employee-crew-role-id").setAttribute("value", crewRoleID);
}

function airlineTabClick(e1, v1, e2, v2, e3, v3, e4, v4, e5, v5) {
		
	document.getElementById(e1).setAttribute("value", v1);
	document.getElementById(e2).setAttribute("value", v2);
	document.getElementById(e3).setAttribute("value", v3);
	document.getElementById(e4).innerHTML = v4;
	document.getElementById(e5).setAttribute("value", v5);	
}

function airlineModelTabClick(e1, v1, e2, v2, e3, v3) {
	
	document.getElementById(e1).setAttribute("value", v1);
	document.getElementById(e2).setAttribute("value", v2);
	document.getElementById(e3).setAttribute("value", v3);
}

function airportsTabClick(e1, v1, e2, v2) {
	
	document.getElementById(e1).setAttribute("value", v1);
	document.getElementById(e2).setAttribute("value", v2);	 
}

function flightsTabClick(e1, v1, e2, v2, e3, v3, e4, v4, e5, v5, e6, v6, e7, v7, e8, v8, e9, v9, v10) {
	
	document.getElementById(e1).setAttribute("value", v1);
	document.getElementById(e2).setAttribute("value", v2);
	document.getElementById(e3).innerHTML = v3;
	document.getElementById(e4).setAttribute("value", v4);
	document.getElementById(e5).innerHTML = v5;
	document.getElementById(e6).setAttribute("value", v6);
	document.getElementById(e7).setAttribute("value", v7);
	document.getElementById(e8).setAttribute("value", v8);
	document.getElementById(e9).innerHTML = v9 + " " + v10;
}