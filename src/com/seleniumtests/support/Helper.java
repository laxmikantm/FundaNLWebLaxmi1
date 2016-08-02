package com.seleniumtests.support;

import static org.monte.media.FormatKeys.EncodingKey;
import static org.monte.media.FormatKeys.FrameRateKey;
import static org.monte.media.FormatKeys.KeyFrameIntervalKey;
import static org.monte.media.FormatKeys.MIME_QUICKTIME;
import static org.monte.media.FormatKeys.MediaTypeKey;
import static org.monte.media.FormatKeys.MimeTypeKey;
import static org.monte.media.VideoFormatKeys.CompressorNameKey;
import static org.monte.media.VideoFormatKeys.DepthKey;
import static org.monte.media.VideoFormatKeys.ENCODING_QUICKTIME_JPEG;
import static org.monte.media.VideoFormatKeys.QualityKey;

import java.awt.AWTException;
import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.NoSuchFileException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.monte.media.Format;
import org.monte.media.FormatKeys.MediaType;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;




public class Helper {

	public static Logger loggerHelperLevel = Logger.getLogger("Helper");

	public static final String BaseURL="https://www.pond5.com/";
	public static final String LandingPage="stock-video-footage/1/car.html#1/2063/car";
	public static final String SEARCH_KEYWORD = "car";
	public static final String EXPECTED_VIDEO_TYPE = "car";
	public static final String GOOGLE_TAGMANAGER = "www.googletagmanager.com";

	public static final String EXPECTED_TITLE_LANDING_PAGE = "Car Stock Footage ~ Royalty Free Car Stock Videos | Pond5";


	public static boolean isAlertPresent(WebDriver driver)
	{

		try
		{
			driver.switchTo().alert();
			return true;
		}   // try
		catch (NoAlertPresentException Ex)
		{
			return false;
		}   // catch
	}   // isAlertPresent()


	public static boolean isElementPresent(By by, WebDriver driver) {
		try {
			driver.findElement(by);
			return true;
		} catch (NoSuchElementException e) {
			return false;
		}
	}


	public String getClassName(Class<?> intendedClass){
		String className="";
		Class<?> enclosingClass = this.getClass().getEnclosingClass();
		if (enclosingClass != null) {

			className=enclosingClass.getName();
		} else {

			className=getClass().getName();
		}
		return className;
	}

	public static String getCurrentTimeString(){
		String timeString="";
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-hhmm");
		Date date = new Date();
		timeString=dateFormat.format(date);
		return timeString;
	}




	public static void takeScreenSnapShot(final WebDriver driver,String prefix) throws IOException{

		String fileName="";

		fileName += prefix;


		DateFormat dateFormat = new SimpleDateFormat("-dd-MM-yy-hhmmss");
		Date date = new Date();

		fileName +=dateFormat.format(date);

		File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try{
			FileUtils.copyFile(srcFile, new File("target/snapshots/"+fileName+".jpg"));
		}

		catch(NoSuchFileException e)
		{
			System.out.println("Unable to access folder for Snapshots");


		}

		return;
	}

	public static void takeFieldSnapshot(WebDriver driver,WebElement element, String prefix) throws IOException  {

		String fileName="";
		fileName += prefix;


		DateFormat dateFormat = new SimpleDateFormat("dd-MM-yy-hhmmss");
		Date date = new Date();

		fileName +=dateFormat.format(date);

		File screen = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

		Point p = element.getLocation();

		int width = element.getSize().getWidth();
		int height = element.getSize().getHeight();

		BufferedImage img = null;

		img = ImageIO.read(screen);

		BufferedImage dest = img.getSubimage(p.getX(), p.getY(), width,
				height);

		ImageIO.write(dest, "png", screen);

		File f = null;

		FileUtils.copyFile(screen, new File("target/snaps/elementSpecific/"+fileName+".jpg"));

	}


	public static ScreenRecorder screenRecorderSetup() throws IOException, AWTException{
		ScreenRecorder screenRecorder;

		GraphicsConfiguration gc = GraphicsEnvironment
				.getLocalGraphicsEnvironment().getDefaultScreenDevice()
				.getDefaultConfiguration();
		return screenRecorder = new ScreenRecorder(gc, new Format(MediaTypeKey,MediaType.FILE, MimeTypeKey, MIME_QUICKTIME),
				new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey,ENCODING_QUICKTIME_JPEG, CompressorNameKey,
						ENCODING_QUICKTIME_JPEG, DepthKey, 24,FrameRateKey, Rational.valueOf(15), QualityKey, 1.0f,
						KeyFrameIntervalKey, 15 * 60), new Format(MediaTypeKey,MediaType.VIDEO/*MediaType.<span class="searchterm5">VIDEO</span>*/, EncodingKey, "black", FrameRateKey,Rational.valueOf(30)),
				null);


	}



}


