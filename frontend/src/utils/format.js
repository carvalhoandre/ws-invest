import { format } from 'date-fns'

export const round = (value, precision) => {
    var multiplier = Math.pow(10, precision || 0);
    return Math.round(value * multiplier) / multiplier;
}

export const formatLocalDate = (date, pattern) => {
    const dt = new Date(date);
    const dtDateOnly = new Date(dt.valueOf() + dt.getTimezoneOffset() * 60 * 1000);
    return format(dtDateOnly, pattern);
}
