var selectedWord;

$(function() {
	// Initialize the tree inside the <div>element.
	// The tree structure is read from the contained <ul> tag.
	$("#tree")
			.dynatree(
					{
						initAjax : {url : "./JSON/TreeData.json"},
						autoCollapse : false,
						selectMode : 2,
						minExpandLevel : 2,
						fx : {
							height : "toggle",
							duration : 200
						},
						autoFocus : false,

//						persist: true,
						onPostInit : function(isReloading, isError) {
							this.reactivate();
						},

						onActivate : function(node) {
							
							
							
							
							var iframe = document.getElementById("resultFrame");
							
							
							 
								selectedWord=node.data.title;
								
								iframe.contentWindow.ResetSearchvalue(selectedWord);
								
								iframe.contentWindow.LoadDescription();
								
								iframe.contentWindow.Reset();
							
							
							},

				});
	

});