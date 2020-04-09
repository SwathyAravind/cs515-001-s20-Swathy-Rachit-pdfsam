/* 
 * This file is part of the PDF Split And Merge source code
 * Created on 12/dic/2014
 * Copyright 2017 by Sober Lemur S.a.s. di Vacondio Andrea (info@pdfsam.org).
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as 
 * published by the Free Software Foundation, either version 3 of the 
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.pdfsam.splitbysize;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author Andrea Vacondio
 *
 */
public class SizeUnitTest {
    private static final long KB_TO_BYTES = 1000;
    private static final int sizeToSplitAt = 5;

    @Test
    public void toBytes() {
        assertEquals(sizeToSplitAt * KB_TO_BYTES, SizeUnit.KILOBYTE.toBytes( sizeToSplitAt ));
        assertEquals(sizeToSplitAt * KB_TO_BYTES * KB_TO_BYTES, SizeUnit.MEGABYTE.toBytes( sizeToSplitAt ));
    }
}
