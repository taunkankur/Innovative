/**
 * 
 */

var articleData;
function  loadMe() {
	
	(function($) {
	    $.QueryString = (function(a) {
	        if (a == "") return {};
	        var b = {};
	        for (var i = 0; i < a.length; ++i)
	        {
	            var p=a[i].split('=');
	            if (p.length != 2) continue;
	            b[p[0]] = decodeURIComponent(p[1].replace(/\+/g, " "));
	        }
	        return b;
	    })(window.location.search.substr(1).split('&'))
	})(jQuery);
	
	var Data=$.QueryString["Data"];
   
    // alert($(xml).find("title").text());
     xmlDoc = $.parseXML( Data ),
     $xml = $( xmlDoc );
     $($xml).find("result>hits>hit>info").each(function(){
       // alert($(this).find("result>hits>hit[id=2362951]>info>title").text());
        $( "#div1" ).append( $(this).find("result>hits>hit>info>title").text() );
      //alert($($xml).find("result>hits>hit>info>year").text());
        $('#myTable > tbody:last').append('<tr><td align="left" ><a target="_blank" style="color: #000000; text-decoration: none;" href='+$(this).find('title').attr('ee') +'>'+$(this).find('title').text()+'</a></td> <td>'+$(this).find("year").text()+'</td></tr>');
      });
}

function ResetSearchvalue(){
	
}