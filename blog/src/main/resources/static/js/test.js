let index = {
	init: function(){
		$("#btn-result").on("click", ()=>{
			this.result();
		});
	},
	result: function(){
		let data = {
			num1: $("#num1").val(),
			num2: $("#num2").val(),
		};
		
		$.ajax({
			// 글쓰기요청
			type: "POST",
			url: "/test/result",
			data:JSON.stringify(data), 
			contentType: "application/json; charset=utf-8", 
			dataType:"json" 
										
		}).done(function(resp){ 
			alert("전송이 완료되었습니다.");
	
		}).fail(function(error){
			alert(JSON.stringify(error));
		}); 
	}
	
}