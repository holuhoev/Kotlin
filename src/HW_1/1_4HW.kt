package HW_1


/** Изучить функцию конвертации Java-кода в Kotlin-
код
Сконвертировать какой-нибудь свой (если есть)
проект. Если нет своего проекта, можно взять
понравившийся с GitHub.
Как вам получившийся код?
Работает?*/


import java.util.UUID

/**
 * Created by evgenijlebedev on 11.03.17.
 */
class VirtualMemory
{
    private val list: MutableList<ByteArray>? = null

    internal fun allocateSpace(size: Int): UUID
    {

        val array = ByteArray(size)

        val id = UUID.nameUUIDFromBytes(array)

        list!!.add(array)

        return id
    }

    internal fun freeSpace(uuid: UUID)
    {
        for (arr in list!!)
        {
            val id = UUID.nameUUIDFromBytes(arr)
            if (id === uuid)
            {
                //arr = null
                /** в  Java arr - variable, а тут val*/
                break
            }

        }
    }
}