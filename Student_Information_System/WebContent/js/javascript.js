function validateName(){
	var name = document.getElementById("commentName").value;
	if(name.length==0){
		producePrompt("Name is required",commentNamePrompt,red);
		return false;
	}
	else
		{
	producePrompt("Name is valid",commentNamePrompt,green);
	return true;
		}
}


function producePrompt(message,promptLocation,color){
	document.getElementById(promptLocation).innerHTML=message;
	document.getElementById(promptLocation).style.color=color;
}