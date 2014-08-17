package net.objectlab.kit.datecalc.common;

import java.util.List;
import java.util.Set;

/**
 * A DateCalculator specialised for a currency pair. Implementations should be thread safe and immutable.
 *
 * 'E' will be parameterized to be a Date-like class, i.e. java.util.Date or
 * java.util.Calendar (and LocalDate or YearMonthDay for Joda-time / JDK8).
 *
 * @author Benoit Xhenseval
 *
 * @param <E>
 *            a representation of a date, typically JDK: Date, Calendar;
 *            Joda:LocalDate, YearMonthDay; JDK8: LocalDate
 * @since 1.4.0
 */
public interface CurrencyDateCalculator<E> {
    E calculateSpotDate(E startDate);

    E calculateTenorDate(E startDate, Tenor tenor);

    List<E> calculateTenorDates(E startDate, List<Tenor> tenors);

    String getName();

    String getCcy1();

    ReadOnlyHolidayCalendar<E> getCcy1Calendar();

    WorkingWeek getCcy1Week();

    String getCcy2();

    ReadOnlyHolidayCalendar<E> getCcy2Calendar();

    WorkingWeek getCcy2Week();

    ReadOnlyHolidayCalendar<E> getUsdCalendar();

    WorkingWeek getUsdWeek();

    SpotLag getSpotLag();

    boolean isAdjustStartDateWithCcy1Ccy2();

    boolean isUseUsdOnSpotDate();

    Set<String> getCurrenciesSubjectToUSDForT1();
}
