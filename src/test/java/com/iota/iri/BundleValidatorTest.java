package com.iota.iri;

import com.iota.iri.conf.Configuration;
import com.iota.iri.controllers.HashesViewModel;
import com.iota.iri.hash.Curl;
import com.iota.iri.model.Hash;
import com.iota.iri.storage.Tangle;
import com.iota.iri.storage.rocksDB.RocksDBPersistenceProvider;
import com.iota.iri.utils.Converter;
import com.iota.iri.controllers.TransactionViewModel;
import org.apache.commons.lang3.ArrayUtils;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Created by paul on 3/5/17 for iri.
 */
public class BundleValidatorTest {
    private static Tangle tangle = new Tangle();

    @BeforeClass
    public static void setUp() throws Exception {
        TemporaryFolder dbFolder = new TemporaryFolder();
        TemporaryFolder logFolder = new TemporaryFolder();
        dbFolder.create();
        logFolder.create();
        tangle.addPersistenceProvider(new RocksDBPersistenceProvider(dbFolder.getRoot().getAbsolutePath(), logFolder.getRoot().getAbsolutePath()));
        tangle.init();
    }

    @AfterClass
    public static void tearDown() throws Exception {
        tangle.shutdown();
    }

    @Test
    public void isInconsistent() throws Exception {
        String[] trytes = {"999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999CFDEZBLZQYA9999999999999999999999999999999999999999999ZZWQHWD99C99999999C99999999CKWWDBWSCLMQULCTAAJGXDEMFJXPMGMAQIHDGHRBGEMUYNNCOK9YPHKEEFLFCZUSPMCJHAKLCIBQSGWAS999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999","999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999ZZWQHWD99B99999999C99999999CKWWDBWSCLMQULCTAAJGXDEMFJXPMGMAQIHDGHRBGEMUYNNCOK9YPHKEEFLFCZUSPMCJHAKLCIBQSGWAS999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999","999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999VUWVAYOAJBZ9999999999999999999999999999999999999999999ZZWQHWD99A99999999C99999999CKWWDBWSCLMQULCTAAJGXDEMFJXPMGMAQIHDGHRBGEMUYNNCOK9YPHKEEFLFCZUSPMCJHAKLCIBQSGWAS999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999","999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999FPHIWXZWXNFVHFOUKSIAKQIEQCFGQRJLWXHOLAQV9ALVRMAXQSASTPWAAVAKHHLRLXFGGIUYQDVRUHHRQB99999999999999999999999999999999999999999999999999999ZZWQHWD99999999999C99999999CKWWDBWSCLMQULCTAAJGXDEMFJXPMGMAQIHDGHRBGEMUYNNCOK9YPHKEEFLFCZUSPMCJHAKLCIBQSGWAS999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999"};
        List<TransactionViewModel> transactions = Arrays.stream(trytes).map(Converter::trits).map(t -> new TransactionViewModel(t, Hash.calculate(t))).map(t -> {
            try {
                t.store(tangle);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return t;
        }).collect(Collectors.toList());
        Assert.assertTrue(BundleValidator.isInconsistent(transactions, false));
        Assert.assertFalse(BundleValidator.isInconsistent(transactions, true));
    }

    @Test
    public void validate() throws Exception {
        String[] trytes = {"999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999SQYSGYNQDUEMYK9RSEJXLBSGWBSEVIMZWQPHLMPKBAIJCTAEPDYLLRTESZSW9FMQYNSGQZKRKCXGNUWDOA99999999999999999999999999999999999999999999999999999RMADHWD99999999999D99999999ZOQVEZLHTJMXYPWTH9OKHSDKBNP9UCISSBKFNAVSCUEQBBOQBMEUSZDRJQJLTKENOJUOYLETFT9JRIKUCOFPLCLNEBUUIJBFHXKQTAQFCZZACGXQEGPTUUMGYXWSEFUK9MKTVJRPUUJESLUSN9FPRHMMLBRNG99999IHAVDVHYJDKRYAOTUYNJCSNERFHACSDTCQIO9IPWSUGQN9DAVNJRUNLMZSRRFLUFLTRSGYVJLKOCW9999RDDGUFUSZZMJIGAHCWHWCNNBHSLYVCPBZOHGQQPMIPTWCMREXAQY9IIWOSYSUUWMBQOAUTXBZ9DOWWMPF","XXNZSYGCAIEQA9JXNUNAFYGOKRPFPFONH9SNPOKQHURAKQBDDWUIXSFCNFZLTJQJXDJZEMIHLIQTF9NXWKPDCX9PUBVIAJFBCZLBSXUSMBUUBTZWBWFBXARYKGHWZR9ZYVKX9WDTXMQIUFCZJZVMGTFOAFKKPWKAGB9N9BUWJJFELOFMCWZGIGEEZWXYBQONGGC9IRHPDHSSJYMBUAFTRWPCGACLSKXZYLHXHXZRSKCOVQLSGEIJN9LEPBEHMZOUUBTCNRGGJVAJFTFTYY9LKSPZHWTSCWNKSQX9YGDSXIDKGDRNYBPGPSSTEWTIXQNLRINFKGXVNXSCW9ZBDRSB9VTPLFBGHNAZBFDDLT9LASDQLZRXY9JNNMZZHNPAKKOOMVWTYPANBD9NRLXEWIHWYMQEEZOLDIMUN9E9OTAFVHECVYXRX9JSCLEOPLVQIQEPJSD9WSZUMP9PIKXUZNUJGTGRGIOIFFNKJLNTKXOZLJRYU9GQUORELHNTGDWGILC9ULWUNAFDFRKRFDAZFVUCRZIEFEOKQJBVRAHKPDOQZGCAPOFOHYYW9WKEFCMTBWCAMYPETEGGIVTDW9XQZSAZAXRCGWRQMWJYJFQETCJTXUHUKT9RQUVZCBDCUU9LUJIWZS9JUBKTHNCYJIWZDDBMESNXGIOVMTJLTWLRMGUBDYGJDOAMWBDLBFIHYPG9LJEACRUQPCYDWLFLVQKALHSYQHFTVQ9KBMIBUDUAOGWAKSHWROYVCUGSMWEDCZRFPI9CANMUKGUPOKMBRXSWWWBWJV9J9AQVMNJYIBKLKYI9ZVPUGREKQJTOFIZBHFUZLMYUS9HKEEXYQNHKVXXDWBKJWZFYWYXIKKWUY9FDYAFVPTRVRLQJBAHDMPIHBNBJSZQQOBY9NMPSOCCWPGVR9HFINQBKTMWYDTXBBMDKUVUQVXYHGHDOBEUFKLZNMCMZCQUWYVYSWTMOFQLMMWSZRFLWKGRDONAILWZBDFBFJNMHXJPALIPACNYVMRMRYXQICWTIJ9GQBJFESKRY9ITDESPIJUZZVTIVHGZXWZDKKOTEFQQQAJMSWREAS9RNU9UGMEYEIJUQS9QMYN9EYUQOSXJZGWUFRIWMDTANDQRSTRYTUYEDR9SLKEDTVUK9GHCNNV9SKYEZGGIX9TV9KZQIYEPUSVYLTLGITGNOEQWZ9OQVXKPOKPWUQLHC99GMIAYOTEAROETWWHXWCDNPLVFRMCPYWVIEXW9ZADDVQETTGNOJHYYKUONAIKUUUFRQYZCDRXQIJBR9JNRTYEFDFYLZWMCYYHCKOYRNLDKSRZBZNCWRLHJWGGC9BRJOLZEMTXTUNZDJLXVQFKAJYQYSOZAKHIMYJJODQVGXEP9DAROUAFTXCNBPVEEYPHPTDGISRKSVKSQTBRSMXVSOVNQKAUGMOFQVNVXZSEDSSNCWNTPM9PHNLDCXHAWZCDIXIXRZGIRZI9HQMBFLQUUPNPJNOGWFISPFVWPQDOHJDBRWWCDOXDDZRPFLDWQZPNIKHJKNPHLLUBMNCXNBDEXDAGUDQCEJDFQMLPRU9ACLMUO9ZIBNHSRIFJZLKFFPBBZTQULZMDWTQSFNFXLZSJHJFPZLYKJTJJYIAIJPUF9WOQBMLXLMDAGTGHZJHACSUKEYZGRMIIEYPTGOVBFEQSRQGRZPYZUFWENIMCWJI99QAZECSHAQUEKBIEEF9OCMXELOJQEVC9DBOJNBHAPJMYKFFOWJZULHVXI9HVIGYSLIJZZTZWGZKYCSJWHI9FHWXZRQFLARHRKNKNBTF9ZDGJWKMNUMGKZR9RDE9WAQTGEVUGUWOCIAGQUWGU9MFDJ9GEVYRUYVASAKCCRQAOTRPWIHTLUZRKGDLQKRRNVZCUJ9GIBRD9JNDBH9UXGUPKQHQWLXZFGJPJDNMGNFEPJXADBAEZJYCJMRWXVHLX9A9XRXEAQAGMV9PZKLEYMNYOPCYFLRSE9MTHBAMNFKGQZIKEYHREYDSGNPMTWUNZMUHYAYVAXGDDAYYAH9XJZNKKIGXIHMSVEQXLU9V9EOXAYGALR9IBDVUOLAUQJZBCAULWHOFRBUBIKMRMSFKIOORNWKQZDICNDWURUUULCXHVCFYIYUTSPRITRPBRNLGQJYY9AK9DOCNLQRGUWBVTRQBG9ZREODTIVHWR9DQQRIIZ9YK9CIVHCLTLPVFBXRGDFVPEGUWELMHHMXKNT9HIFOIHM9JQWNWKKBZTULZYBQPBJKEXJXVGWCYMZESZP9BSMR9RVPW99999999999999999999999999999999999999999999999999999RMADHWD99A99999999D99999999ZOQVEZLHTJMXYPWTH9OKHSDKBNP9UCISSBKFNAVSCUEQBBOQBMEUSZDRJQJLTKENOJUOYLETFT9JRIKUCHKJQFWCAKUHH9WRIIHUONWGGHMVFHFLDLVZRHMFTUTLHTPFJSRSTFCDEKGHWWTIBZEIHRKGNEWLIZ9999IHAVDVHYJDKRYAOTUYNJCSNERFHACSDTCQIO9IPWSUGQN9DAVNJRUNLMZSRRFLUFLTRSGYVJLKOCW9999CAQZGGJSMAKHNOGVSTB9YEEOPKYDX99ZHFHEPQVIOUHFPYPWAZAYX9FRQTEIDLPHCPLHHJEQIIXSDWDYH","HCUVJXWHAGTFNYYSBKOMBXQQ9PIZPKJXQJQQLNBMAQBVRTKSZUFMQVXJYAXWAMHLRWRFYBIEQADZZJMCQVAFBPUNNN9MODLWPDPVYFLTQFMODIOSQVGCIQUDQHPVFSIAANWIEHZGQLIZSYVUFNVCXHYPTXWMCDFWE9GRWJXQFCVSIQTMKAWTO9YGIIWXQPBPPQZQDWPHGMPZKHSBKLFXNGZ9SBQXOYJUQYSCAFQG9BYROYPXBFDXTBIZTJCVFXIFHJHKGHEVJWQAMOY9XZFZVTHLOP9YWRNKBDCFNSO9INNFACWWWZMQTZCETNUCLE9P9DTRHA9ASLIWPDZCFHPZNBGE9WTUBZEBXQAWWTVJNIZYVVHOGJVEVTJPFWFQEUMPBJFXKECGMZNGUNXHHZUBFCBBSFVSHEVCOSNASU9IWCA9ODIOAEAMORVFDMKKURAWFOIOM9C9DWOAD9JLKJAQDT9MKHZMARHRZSISCEBNOTQTF9GNWOVVIPEUSBSCMRUKVAARGUDACXEMNGIQIEIOGSSKVFD9VZYNOKKI9GXCZODFYVNUV9NDXTBQGRULIRXZULWX9JTKXZNKMDXBEJRCEIHJOJDPIMIMFNGT9XQUHJF9VCFPMMAWLICQLUJWQRPADCTZD9UXTWPVLNXVVQLXJIFAJIIPWKCOYMPXMQDNJF9YJWCFCVLXIJBHJDQKIBCMD9SGMJDLRIODOLKJVUBPYMQC9AQFFQ9VNMZUXSPJJONWCQQM9DQUJPLVOFLPFGYPUMXBULSL9FGKHLLRPJEGRQFAQKRJCOZLPLDOAB9OVEARC9KORJTMJ9OJWAFYLRNNZJXORMDWNKWKUCQFXPZYTSGAFADBJIDOPAZHVGRM9MCMGVFZXNET9QZGMMETXANFWGUISCSIHQDPHNXUFTEVBKMGXMO99KBJNBI9HLKJ9EYQSMPJGLLNDRMWQMGUMTYIAIOMCZCHEGHXRQRQELM9VYRPRYGIQOXHHFZTKIUVGWBNURXDTWUECI9NMTYWBJXGCDJFFPFGJDHQYAOHBMIFWINZFBYXFUWFFFTKIRFHDIBZUGRZTGORIVPFIXAHVPROKREUYNBIRRQKDFCBGZMFJLZVEJHFMMHFZQHGQGKQ9JKYVPPPHQOMAZUBVZXEVZQCBJACECANBGMBXKPVZJONEMJTIRDLKYBJCDUQNTCY99LOKEZDANWFJWWWV9PFRFGQPHTLZUZPYRPWLFNYGXJADMAP9BRCNZTTNCCYFAJTISVEKDRMAMUSTXKW9RIEMWPDXIVVJZCINIWPCRGNWLMLNGZNVCXMHOQNPAQLGZFJMFADQDYCIQGXQXPSUKFHNNZKWXMJGRIFQENFRBCFRSTJWBQY9RXDFGPLGSEHQUXO9XMQUVUDQGWFTUG9TGVAAMFBFFYUMFBLHWMFMWYACNAPQXBDRUEB9N9HEEDGCUORJLFMSGSNKGXXQLIZBBRQUCNLKPVPXC9SASO9FFTHLWUIZNJWBLNIAERCEEMONHEIOPBBBXPPDFUHRBWESMIKLSYGQVBUSRYZUAJZQFHUDQAONWRS9ENDTUTXKXEHNKCMJSEZBYKEOOXQEHHDCV9VSM9WUGH9CIJHNNMBXULIMKF9XPP9NZWSVETCLLAZ9HMNXO9UGORLINRZYQB9MUODMIMTZYWVVUAWBCLVKIGFFGEIDYCLAPHNUZWTZPDO9VWLNKMKEPNUUTYFDSQWEPXJTUKCQ9X9PIJC9LEOZDIXLBMG9KJYTGJXRDYSPW9UQHFMOSUXAHGKGAKW9NMEBXEKWCPEHUNAPACKARZ9OVZHYGHXK9NQDJZUGYZPXLTJINUDPOXURONZJRQDGJQKFQNNSVJHSEKXMHSWPMTKWCVEZCNDZXW9YAPGHMKWOBAGSVYWMTMSBRJCLVXEERMFZF9HELHKXWEBXCUTAVGWHFKXGDKQLXKMHMPEPRHUQWDWOSPUMIHVECHPEKNEDKETTTJIFTWACQJYWRJILPWIJ9QDOOJCIUKHLKOJZFLBAWIXEOJRA9FRZCHDCGUKFLEHQDCAWSAHZCZMYDLIFZONEEJCRAERWAPDKYFYGIPKDVVWHSCQOZGRGPTB9CHKTEIPYHEDBCYONFXOZHYPU9TODVBW9DVEBYXSKOOHOQNIYVGJVOTVDBSHRJDBXPDOUZJKCFBQIAW9B9GBIYRMZXVLTLPVFBXRGDFVPEGUWELMHHMXKNT9HIFOIHM9JQWNWKKBZTULZYBQPBJKEXJXVGWCYMZESZP9BSMR9RVP999999999999999999999999999999999999999999999999999999RMADHWD99B99999999D99999999ZOQVEZLHTJMXYPWTH9OKHSDKBNP9UCISSBKFNAVSCUEQBBOQBMEUSZDRJQJLTKENOJUOYLETFT9JRIKUCERKBDANKIXHFQUDAFDOSHLMTSJHDLANIOMTPFSOKZLPGAXLMSDHZPYJNTJCLBMLPNL9FGPXJYL9TB9999IHAVDVHYJDKRYAOTUYNJCSNERFHACSDTCQIO9IPWSUGQN9DAVNJRUNLMZSRRFLUFLTRSGYVJLKOCW9999GIJLOB9JHRAOEIYGATGQFHTFQQLQGYLSDBUSYVMYUTNWEFMPBWEZPSFUNRCTIPYGGBDJMLTLRHHZLJY9U","NFMEYBDWZZDZHHLP9BGGGIBQUABDDVXLXRGJXNLQFJKTHNZGLICCWEGTTXUBFLGEIGDTWMHLPHJEWMUCFFSVUKMNVHOWWPYBEWGMJJSXBUW9HHVRXRITSGHAXRXLGLGIGUDSYXUUC9HDUTRULP9PVXYKSBTQIQKUWJPSMCXUHPHXWWUWWYLOXFAYUAPHFF9IBEMLULONQXEQCGCCMVNMGCYDKHNKOMDKZK9EM9XHSKN9AVHHSFSEBAQPHVXBBHXZHEQFZRNZMGBZYDGXRD9WCFC9UIGADQTODLFFEQDEULSMIS9AFUWDKGGHKPICXZLFDUDLTNQNOC9TRXANSNDCTFDN9XLN9YNAOMJESMSQBEUESRT9HVAHNWJBAYY9XIZMXFNWSFWEGDAFKKLVZAHCSNVEJBJNEAKJUIRC9EEXPYAIEVUCWXAHWKKV9QEWVMXYAC9LPDFEQSWQLFL9RITCOLVIUWMGBNPBABKHQJBPNJXRPEAHKWVKRPMTJRUNSRHUFMYLVWOQRMQUYZWZWHBYEOWPOPJ9HHBGSGMLVWFASUURCUHQCIFTNBIOSWJMFBDOOQVPGOORKOXQAWZRGAPM9JARLUOFFIYUIHPVHYFQDAVNNUSNNHGVRJASBBJDTKZACZDFSKZUR9DFOZWOXRCFFGIODNWFKBHKWZCXZIHYUETXLOZQVEUPFMCPJTPNKAEXUPMCVIPTEMPT9LYSI9PWB99IREFXTEED9HZZFBKZRNDRCVLAAGQZZCRQUMZLZAUUYWGFAORJRGDIHCNQMBKUHKFFBWHZEFSMGVRLHKEYAPVVBMBMSYI9WGLDSJUAHAMRZVCDTQUICEOTHFHOHGITSRBUDGSEBNKWJDYQDEYIEFRCVMVPTE9GERKHURZYJNDMWNUZQPQYQZYGDSTGCQP9XOSIPVOYHP9RUTHIWNADERBSYPOAYZHDDXYZKAYJZZVKWB9HCKRSFDLRLTVLSGAP9SVXCXQMNIDFJQRDFEKPDWFSHOMACEQLTTQZJUUX9EEHBXICKOXYTQYKLMEFBZWZZ9RSTLJMESPYAVR9FJNTTRSJWRE9TN9OBRGNDOCOAQWBZYDYRWSKSJAVZHPUFVG9EAUBMEQVVVKTODNABBGDKRLXEPFFLVKCOKSDZXVMUTHTSXQMXFRW9GDQCT9KKDVBZLBBLOWMBTYSAIRGNIUWXDJDRMHVXZVQUTHECZVEUPINSTUNDCKADWIENEPZCXB9KA9VAMIJTEBQ9AZOSPEPWTDYJZVFKSZFPBFZG9BGWFJUPQHOHQQRWRABJPCPTVQYSFEWMOCKMVKQOOWIUWRHWXAMBUV9KCZKOYYSTHINUUMCCXLGVDGABGCCTPSEQIEQQETCVIOQMEPRVMQGILYGDQUFUD9ZEEZBLZNVUMLTLSYRGIOAEQLOWTZEDBGZHJOUI99UJACEBRYZTFVHHBKOPBQXAONUMNKMOQZERZTJRSPLIDVCECUELEAOAICLGCRRYLNCUPLNGQJQHNLMYQGBLXBEXNVURAOQRCRSSSBMUGBKWAQKQGHS99YIFSUSNOFPPDLEMNMQUVRCGDFPGYDOFOTQMU9GEWWARPG9UNPHJDAYVISCJPOCEYPPUGTQPVIWCWPGPYSNCEGRFDLCMPWTTUBRZKACLO9NABEATWOFEOUBJJWGCGQIBGB9SVUOVIBOZKDPSKCHCXWRCBHDQGBZADGCFDNDFSHCYIBPJDJKXPDLIASOOBD9S9DB9SMX9TKATWZUVLOSUJQQYYSBORTRPQOVUUYUFAZSYAQIBBDSG9KJQNFSOCRQCCB9BYBJPFSBESSNSTNPEUWBI9CYMODOE9IEOWWYPIESIEHWNT9BKKIRXAJRPG9ERRDJNCYVPYCBYIGWSLYKPJCGFOIAQVXTHO9DVGIIWWUNRHAOLHTY9ZXMYWTAVGIACISUAWMDBRISSUBGYIW9PPJMUJTXMSIHM9CCSWXAABTQRYSSOZHWDRJDXFQMBXTFHJMGTPJHZYYAWTB9CFNQNEHDJVIQDLXYEDILOTZK9G9HVNYKKFBVSHCWUMBOZZOL9ER9HJUMGSGZPOFEE9LXRQWBJQNVZTDUPVANILWHUVDKZYGTIKMJQQFXDNAIYWWEJHGBCPAMCOCPKGTEAAVBJUJFLQUNHKPVED9TDBOQKGLHUUGVSMZBSVGGFXBFBNCPKVJLTLPVFBXRGDFVPEGUWELMHHMXKNT9HIFOIHM9JQWNWKKBZTULZYBQPBJKEXJXVGWCYMZESZP9BSMR9RVP999999999999999999999999999999999999999999999999999999RMADHWD99C99999999D99999999ZOQVEZLHTJMXYPWTH9OKHSDKBNP9UCISSBKFNAVSCUEQBBOQBMEUSZDRJQJLTKENOJUOYLETFT9JRIKUCLBKHIWPHSOQRNKCRNEBRWRFVPPSQHENFAPJKLMWZOTVWXDDALUMLVCOXTWEEL9PRYD9CMVTUULUCC9999IHAVDVHYJDKRYAOTUYNJCSNERFHACSDTCQIO9IPWSUGQN9DAVNJRUNLMZSRRFLUFLTRSGYVJLKOCW9999LAAIEDNOAODKHWVDSHBPTASMYDJUIXNIHROGKQOKUYEGEDSGXPBKCLPVHKGSGRGXKZGQKTRCMMNWZODSX","999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999999XXIOBS9NSVFA9AUBBOLXBNXNEXIEYAXVXITMWRGUCJNSMPGDZNCZUVAKPG9NNWLKLQJIINXLD9HVEBPVWC99999999999999999999999999999999999999999999999999999VMADHWD99D99999999D99999999ZOQVEZLHTJMXYPWTH9OKHSDKBNP9UCISSBKFNAVSCUEQBBOQBMEUSZDRJQJLTKENOJUOYLETFT9JRIKUCIHAVDVHYJDKRYAOTUYNJCSNERFHACSDTCQIO9IPWSUGQN9DAVNJRUNLMZSRRFLUFLTRSGYVJLKOCW9999MYZPDMYYXPQGOANGLNMWZPAD9WNKKASTLDROFMAEZHXDTMTDCPSGTVMUMSXPEWIWLXMIUQTOAEMRX9999YSXGJFBLETJTPG9LTUJPPZYCSORFLSFUXVREBLQ9XAASFHSXGFKRPGQLIVOJRDFECSDJPEWQUKTXKWGDD"};
        List<TransactionViewModel> transactions = Arrays.stream(trytes).map(Converter::trits).map(t -> new TransactionViewModel(t, Hash.calculate(t))).map(t -> {
            try {
                t.store(tangle);
            } catch (Exception e) {
                e.printStackTrace();
            }
            return t;
        }).collect(Collectors.toList());
        Assert.assertTrue(BundleValidator.validate(tangle,transactions.get(0).getBundleHash()).get(0).size() == transactions.size());
    }


}