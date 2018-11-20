<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">

    <xsl:template match="/">
        <html>
            <body>
                <h2>My Greenhouse</h2>
                <table>
                    <tr bgcolor="#9acd32">
                        <th>Name</th>
                        <th>Soil</th>
                        <th>Origin</th>
                        <th>Growing Temperature</th>
                        <th>Growing Watering</th>
                    </tr>
                    <xsl:for-each select="greenhouse/flower">
                        <tr>
                            <td>
                                <xsl:value-of select="name"/>
                            </td>
                            <td>
                                <xsl:value-of select="soil"/>
                            </td>
                            <td>
                                <xsl:value-of select="origin"/>
                            </td>
                            <td>
                                <xsl:value-of select="growingTips/temperature"/>
                            </td>
                            <td>
                                <xsl:value-of select="growingTips/watering"/>
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>

</xsl:stylesheet>