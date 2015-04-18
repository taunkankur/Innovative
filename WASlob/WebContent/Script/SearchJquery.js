$(document).ready(
			function() {
				var vFixed = 0;
				var vIsTreeClick = 0;
				$('#files').css("background-image", "url(Image/SearchArrow.png)");  
				
				$("#tree").height($(window).height());

				$("#tree").click(
						function() {
							vIsTreeClick=1;
						});
				
				$("#files").click(
						function() {
					if(vIsTreeClick==0)
						{
							var test = $(this).find("#tree").css('width');
							if (test == "0px" || test == "40px") {
								$('#files').css("background-image", "url(Image/SearchArrowFlip.png)");  
								$('#files').css("height", "40px");  
								$(this).find("div").addClass("docked")
										.removeClass("tree").animate({
											left : "40px",
											width : '280px',
											height: '500px'
										}, 200);
								vFixed += 1;

							} else {
								$('#files').css("background-image", "url(Image/SearchArrow.png)");  
								$('#files').css("height", "100px");  
								$(this).find("div").addClass("tree")
										.removeClass("docked").animate({
											left : "-40px",
											width : '0px'
										}, 200);
								vFixed = vFixed - 1;
							}
							console.log(vFixed);
							$(this).parent().parent().addClass("docked")
									.removeClass("tree");
						}
					else
						vIsTreeClick=0;
						});
			});