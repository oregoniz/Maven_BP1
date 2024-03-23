package proj.skillfactory;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.LoggerConfig;
import org.scf4j.props.PropertyConfigurator;
import proj.skillfactory.comparators.ComparatorStudents;
import proj.skillfactory.comparators.ComparatorUniver;
import proj.skillfactory.enums.EnumCompareStudents;
import proj.skillfactory.enums.EnumCompareUniver;
import proj.skillfactory.objects.Statistics;
import proj.skillfactory.readWrite.FileReader;
import proj.skillfactory.util.StatUtil;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

import static proj.skillfactory.comparators.ChooseComparator.StudComparator;
import static proj.skillfactory.comparators.ChooseComparator.UniverComparator;
import static proj.skillfactory.readWrite.FileReader.studentsArr;
import static proj.skillfactory.readWrite.FileReader.universityArr;
import static proj.skillfactory.readWrite.XlsWriter.xlsGenerator;
import org.apache.log4j.ProperyConfigurator;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Filter;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.Configurator;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
import org.apache.logging.log4j.core.config.builder.api.LayoutComponentBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
public class Main {
    static final Logger log = LogManager.getLogger(Main.class.getName());


    public static void main(String[] args) {
      //  File propertiesFile=new File(homeDir,"WEB-INF/log4j.properties");
     //   PropertyConfigurator.configure(propertiesFile.toString());
        log.info("Программа запущена");
        FileReader.fileRead("src/main/resources/universityInfo.xlsx");

        ComparatorStudents comparatorStudents = StudComparator(EnumCompareStudents.StudentsComparatorByName);
        ComparatorUniver comparatorUniver = UniverComparator(EnumCompareUniver.UnivComparatorByYearOfFoundation);

        studentsArr.sort(comparatorStudents);
        universityArr.sort(comparatorUniver);

        ArrayList<Statistics> statArr = StatUtil.GetStatistics(studentsArr, universityArr);
        xlsGenerator(statArr, "src/main/resources/Statistics.xlsx");
    }
}
