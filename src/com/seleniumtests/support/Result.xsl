<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <head><title>Laxmi Sample Test Report</title></head>
            <body>
                <table border="2">
                    <tr>
                        <th>testcase</th>
                    </tr>
                    <xsl:for-each select="howto/topic">
                        <tr>
                            <td><xsl:value-of select="testcase"/></td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body></html>
    </xsl:template>

</xsl:stylesheet>