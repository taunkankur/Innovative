<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:gd='http://schemas.google.com/g/2005' xmlns:yt='http://gdata.youtube.com/schemas/2007' xmlns:media="http://search.yahoo.com/mrss/" xmlns:n1="http://www.w3.org/2005/Atom" >
	
	<xsl:template match="/">
		
		<Results>
		
					
						<xsl:for-each select="n1:feed">
							<xsl:for-each select="n1:entry">
									<Row Pinned='2'>
											<VedURL><xsl:value-of select="media:group/yt:videoid"/></VedURL>
											<VedThumbNail><xsl:value-of select="media:group/media:thumbnail[1]/@url"/></VedThumbNail>
											<VedTitle><xsl:value-of select="n1:title"/></VedTitle>
											<NumDislikes><xsl:value-of select="yt:rating/@numDislikes"/></NumDislikes>
											<NumLikes><xsl:value-of select="yt:rating/@numLikes"/></NumLikes>
											<PublishedDateTime><xsl:value-of select="n1:published"/></PublishedDateTime>
											<ViewCount><xsl:value-of select="yt:statistics/@viewCount"/></ViewCount>
											<NumRaters><xsl:value-of select="gd:rating/@numRaters"/></NumRaters>
									</Row>
								</xsl:for-each>
						</xsl:for-each>
					
				
		</Results>
	</xsl:template>
</xsl:stylesheet>