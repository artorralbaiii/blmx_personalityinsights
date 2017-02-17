$(document).ready(function() {
	
	
	
	$("#analyze-action").click(function() {
		
		$( "#tradeoff-result" ).html("");
		var html = "";
		var params = new Array();
		
		$("input:checkbox[name=preference]:checked").each(function(){
			params.push($(this).val());
		});
		
		$.post("home",{ "params": params.join('-') }, function(data) {
			
			$.each(data.resolution.solutions, function(index, jsonObject) {
				
				if (jsonObject.status === "FRONT" ) {
					
					$.each(data.problem.options, function(index, options) {
						
						if (options.key === jsonObject.solution_ref) {
							html = html + "<li>" + options.name + "</li>";
						}
						
					});
					
				}
			});
			
			$( "#tradeoff-result" ).html("<ul>" + html + "</ul>");
			
		});
	});
});