/*
	Copyright (c) 2004-2006, The Dojo Foundation
	All Rights Reserved.

	Licensed under the Academic Free License version 2.1 or above OR the
	modified BSD license. For more information on Dojo licensing, see:

		http://dojotoolkit.org/community/licensing.shtml
*/



djd43.provide("djd43.uuid.NameBasedGenerator");
djd43.uuid.NameBasedGenerator = new function () {
	this.generate = function (returnType) {
		djd43.unimplemented("djd43.uuid.NameBasedGenerator.generate");
		var returnValue = "00000000-0000-0000-0000-000000000000";
		if (returnType && (returnType != String)) {
			returnValue = new returnType(returnValue);
		}
		return returnValue;
	};
}();

