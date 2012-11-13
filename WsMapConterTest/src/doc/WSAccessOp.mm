<map version="0.9.0">
<!-- To view this file, download free mind mapping software FreeMind from http://freemind.sourceforge.net -->
<node COLOR="#000000" CREATED="1283850233515" ID="ID_505969708" MODIFIED="1283850501906" TEXT="WSAccessOp">
<font NAME="Calibri" SIZE="20"/>
<icon BUILTIN="gohome"/>
<hook NAME="accessories/plugins/AutomaticLayout.properties"/>
<node COLOR="#0033ff" CREATED="1283850273312" FOLDED="true" ID="ID_1246882357" MODIFIED="1283914660015" POSITION="right" TEXT="operation">
<edge STYLE="sharp_bezier" WIDTH="8"/>
<font NAME="Calibri" SIZE="18"/>
<node COLOR="#00b439" CREATED="1283850652843" ID="ID_1612536850" MODIFIED="1283850878906" TEXT="testFindUserAcctByUserId">
<edge STYLE="bezier" WIDTH="thin"/>
<font NAME="Calibri" SIZE="16"/>
<node COLOR="#990000" CREATED="1283850805796" ID="ID_1337835012" MODIFIED="1283850810250" TEXT="input: string">
<font NAME="Calibri" SIZE="14"/>
</node>
<node COLOR="#990000" CREATED="1283850810703" ID="ID_2309209" MODIFIED="1283850819078" TEXT="output: java bean">
<font NAME="Calibri" SIZE="14"/>
</node>
</node>
<node COLOR="#00b439" CREATED="1283850822156" ID="ID_1673409232" MODIFIED="1283850844250" TEXT="testFindTransRecord">
<edge STYLE="bezier" WIDTH="thin"/>
<font NAME="Calibri" SIZE="16"/>
<node COLOR="#990000" CREATED="1283850892156" ID="ID_1529575223" MODIFIED="1283850899718" TEXT="input: string">
<font NAME="Calibri" SIZE="14"/>
</node>
<node COLOR="#990000" CREATED="1283850900546" ID="ID_961563218" MODIFIED="1283850921187" TEXT="output: java bean ArrayList">
<font NAME="Calibri" SIZE="14"/>
</node>
</node>
<node COLOR="#00b439" CREATED="1283850937078" ID="ID_1072888440" MODIFIED="1283850937984" TEXT="testAddnewUserAccount">
<edge STYLE="bezier" WIDTH="thin"/>
<font NAME="Calibri" SIZE="16"/>
<node COLOR="#990000" CREATED="1283850939390" ID="ID_51801063" MODIFIED="1283850958015" TEXT="input: java bean">
<font NAME="Calibri" SIZE="14"/>
</node>
<node COLOR="#990000" CREATED="1283850942546" ID="ID_608869047" MODIFIED="1283850976671" TEXT="output: primitive boolean">
<font NAME="Calibri" SIZE="14"/>
</node>
</node>
<node COLOR="#00b439" CREATED="1283850986921" ID="ID_1510694687" MODIFIED="1283850988031" TEXT="testFindTrandRecordByIndex">
<edge STYLE="bezier" WIDTH="thin"/>
<font NAME="Calibri" SIZE="16"/>
<node COLOR="#990000" CREATED="1283850989640" ID="ID_620324770" MODIFIED="1283851008406" TEXT="input: primitive int">
<font NAME="Calibri" SIZE="14"/>
</node>
<node COLOR="#990000" CREATED="1283850993015" ID="ID_672169179" MODIFIED="1283851024421" TEXT="output: java bean">
<font NAME="Calibri" SIZE="14"/>
</node>
</node>
<node COLOR="#00b439" CREATED="1283851105765" ID="ID_55002568" MODIFIED="1283851106687" TEXT="testResetDataToDefault">
<edge STYLE="bezier" WIDTH="thin"/>
<font NAME="Calibri" SIZE="16"/>
<node COLOR="#990000" CREATED="1283851120687" ID="ID_278867953" MODIFIED="1283851125625" TEXT="input: null">
<font NAME="Calibri" SIZE="14"/>
</node>
<node COLOR="#990000" CREATED="1283851126062" ID="ID_1394007569" MODIFIED="1283851137515" TEXT="output: primitive boolean">
<font NAME="Calibri" SIZE="14"/>
</node>
</node>
</node>
<node COLOR="#0033ff" CREATED="1283850597671" FOLDED="true" ID="ID_444773772" MODIFIED="1283914871875" POSITION="right" TEXT="extend operation">
<edge STYLE="sharp_bezier" WIDTH="8"/>
<font NAME="Calibri" SIZE="18"/>
<node COLOR="#00b439" CREATED="1283851038312" ID="ID_276854101" MODIFIED="1283914695171" TEXT="testFindUserAndTransactions">
<edge STYLE="bezier" WIDTH="thin"/>
<font NAME="Calibri" SIZE="16"/>
<node COLOR="#990000" CREATED="1283851067890" ID="ID_203872937" MODIFIED="1283851071921" TEXT="input: string">
<font NAME="Calibri" SIZE="14"/>
</node>
<node COLOR="#990000" CREATED="1283851072578" ID="ID_811124275" MODIFIED="1283851089781" TEXT="output: java bean with list in">
<font NAME="Calibri" SIZE="14"/>
</node>
</node>
</node>
<node COLOR="#0033ff" CREATED="1283850560796" FOLDED="true" ID="ID_208137903" MODIFIED="1283937955234" POSITION="right" TEXT="work in processor">
<edge STYLE="sharp_bezier" WIDTH="8"/>
<font NAME="Calibri" SIZE="18"/>
<node COLOR="#00b439" CREATED="1283936407468" ID="ID_635026155" MODIFIED="1283936449156" TEXT="Processor for testing WsAccessOp:testWsOpProc">
<edge STYLE="bezier" WIDTH="thin"/>
<font NAME="Calibri" SIZE="16"/>
<node COLOR="#990000" CREATED="1283937889156" ID="ID_1479113814" MODIFIED="1283937894593" TEXT="Flow states">
<font NAME="Calibri" SIZE="14"/>
<node COLOR="#111111" CREATED="1283936456390" ID="ID_17497562" MODIFIED="1283937911656" TEXT="Initial-">
<font NAME="Calibri" SIZE="12"/>
</node>
<node COLOR="#111111" CREATED="1283937912093" ID="ID_859850456" MODIFIED="1283937916046" TEXT="testWsStart-"/>
<node COLOR="#111111" CREATED="1283937916437" ID="ID_303284686" MODIFIED="1283937920437" TEXT="testWsOpAct-"/>
<node COLOR="#111111" CREATED="1283937920812" ID="ID_1995053651" MODIFIED="1283937927437" TEXT="testWsOpActComplete-"/>
<node COLOR="#111111" CREATED="1283937927812" ID="ID_449179780" MODIFIED="1283937933921" TEXT="findTransactionOpState-"/>
<node COLOR="#111111" CREATED="1283937934234" ID="ID_1167868320" MODIFIED="1283937940031" TEXT="complete/error"/>
</node>
<node COLOR="#990000" CREATED="1283914925187" ID="ID_892605850" MODIFIED="1283936452343" TEXT="as action">
<edge STYLE="bezier" WIDTH="thin"/>
<font NAME="Calibri" SIZE="14"/>
<node COLOR="#111111" CREATED="1283937858437" ID="ID_1666931452" MODIFIED="1283937869265" TEXT="testWsOpAct"/>
</node>
<node COLOR="#990000" CREATED="1283914939359" ID="ID_918348644" MODIFIED="1283936452375" TEXT="as operation state">
<edge STYLE="bezier" WIDTH="thin"/>
<font NAME="Calibri" SIZE="14"/>
<node COLOR="#111111" CREATED="1283937881515" ID="ID_635050386" MODIFIED="1283937882437" TEXT="findTransactionOpState"/>
</node>
</node>
</node>
<node COLOR="#0033ff" CREATED="1283851154343" FOLDED="true" ID="ID_224768634" MODIFIED="1283915080359" POSITION="right" TEXT="negative cases">
<edge STYLE="sharp_bezier" WIDTH="8"/>
<font NAME="Calibri" SIZE="18"/>
<node COLOR="#00b439" CREATED="1283914958078" ID="ID_1595369921" MODIFIED="1283914959218" TEXT="testWsInputMapFmtException1">
<edge STYLE="bezier" WIDTH="thin"/>
<font NAME="Calibri" SIZE="16"/>
<node COLOR="#990000" CREATED="1283914979390" ID="ID_1545946374" MODIFIED="1283914980093" TEXT="When the input map format does not start with &quot;wsInputMapFmt&quot;">
<font NAME="Calibri" SIZE="14"/>
</node>
</node>
<node COLOR="#00b439" CREATED="1283914960031" ID="ID_1383959483" MODIFIED="1283914965312" TEXT="testWsInputMapFmtException2">
<edge STYLE="bezier" WIDTH="thin"/>
<font NAME="Calibri" SIZE="16"/>
<node COLOR="#990000" CREATED="1283914971421" ID="ID_1924054998" MODIFIED="1283914972546" TEXT="When the input map format is not an instance of WSMapperConverter">
<font NAME="Calibri" SIZE="14"/>
</node>
</node>
<node COLOR="#00b439" CREATED="1283914985203" ID="ID_1983700410" MODIFIED="1283915039203" TEXT="testWsOutputMapFmtException">
<edge STYLE="bezier" WIDTH="thin"/>
<font NAME="Calibri" SIZE="16"/>
<node COLOR="#990000" CREATED="1283914991796" ID="ID_1274447935" MODIFIED="1283914992890" TEXT="When the output map format is not an instance of WSMapperConverter">
<font NAME="Calibri" SIZE="14"/>
</node>
</node>
<node COLOR="#00b439" CREATED="1283915000265" ID="ID_1750263170" MODIFIED="1283915076515" TEXT="testWsPrepareExecGetClassException">
<edge STYLE="bezier" WIDTH="thin"/>
<font NAME="Calibri" SIZE="16"/>
<node COLOR="#990000" CREATED="1283915036875" ID="ID_1970559053" MODIFIED="1283915037890" TEXT="When the passed object class does not have a property name &quot;TYPE&quot;">
<font NAME="Calibri" SIZE="14"/>
</node>
</node>
<node COLOR="#00b439" CREATED="1283915047109" ID="ID_1970202866" MODIFIED="1283915047953" TEXT="testWsAccessOpToStrings">
<edge STYLE="bezier" WIDTH="thin"/>
<font NAME="Calibri" SIZE="16"/>
</node>
</node>
</node>
</map>
