package com.javarush.test.level16.lesson13.bonus01;

import com.javarush.test.level16.lesson13.bonus01.common.*;

/**
 * Created by Maxim on 26.10.2015.
 */
public class ImageReaderFactory
{
    public static ImageReader getReader(ImageTypes imgTypes)
    {
        ImageReader r;
        if (imgTypes == ImageTypes.BMP)
            r = new BmpReader();
        else if (imgTypes == ImageTypes.JPG)
            r = new JpgReader();
        else if (imgTypes == (ImageTypes.PNG))
            r = new PngReader();
        else throw new IllegalArgumentException("Неизвестный тип картинки");

        return r;
    }
}
