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
							
							
							showProcessBar();
							hideDataTable();
							
							var iframe = document.getElementById("resultFrame");
							
							
							 
								selectedWord=node.data.title;
								selectedWord=capitaliseFirstLetters(selectedWord);
								togglLable( selectedWord);
								
								iframe.contentWindow.ResetSearchvalue(selectedWord);
								
								iframe.contentWindow.reloadPageTreeView();
								
								//iframe.contentWindow.LoadDescription();
								
								
								
							
							
							},

				});
	

});

function capitaliseFirstLetters(string)
{
    return string.charAt(0).toUpperCase() + string.slice(1);
}