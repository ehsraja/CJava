<xsl:stylesheet version="1.0" 
xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:output method="xml" version="1.0" encoding="UTF-8" indent="yes"/>

<xsl:template match="/">

    <doc>
        <xsl:for-each select="file/text">
            <user name="{user_name}">
                <text id="{@ID}" date="{@date}">
                    <xsl:value-of select="message" />
                </text> 
            </user>
        </xsl:for-each>
    </doc>
</xsl:template>

</xsl:stylesheet>